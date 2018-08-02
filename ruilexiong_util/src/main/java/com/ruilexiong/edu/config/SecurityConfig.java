/**
 * FileName: SecurityConfig
 * Author:   asus
 * Date:     2018/7/30 14:10
 * Description: 访问拦截跳转至登录页
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruilexiong.edu.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈访问拦截跳转至登录页〉
 *
 * @author asus
 * @create 2018/7/30
 * @since 1.0.0
 */
@EnableWebSecurity//开启Security
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //控制请求访问权限
    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //默认访问规则super.configure(http);
        //自定义请求规则
        http.csrf().disable() //关闭CSRF功能
                .authorizeRequests().antMatchers("/", "/login","/register").permitAll()   //主页,登陆页面都可访问
                .antMatchers("/index/**").hasAnyRole("2", "1") //管理员管理页面 首页需要权限 自动生成会添加前缀ROLE_
                .antMatchers("/manager/**").hasRole("1");//manager可以有多个权限
        //开启登陆功能
        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setAuthenticationManager(authenticationManager());
        validateCodeFilter.setAuthenticationFailureHandler(authenticationFailureHandler());
        // 将我们自定义的过滤器，配置到UsernamePasswordAuthenticationFilter之前
        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
               .formLogin().loginPage("/login")
                .usernameParameter("username")//登录页账户 name名称
                .passwordParameter("password")//登录页密码
                .loginProcessingUrl("/index/login")//设置跳转自定义login
                .defaultSuccessUrl("/index/main")//设置默认跳转成功路径(起始位登陆页面的,其他跳转按放行页).defaultSuccessUrl("/index/hello");
                .failureUrl("/login?error=true");
        http.rememberMe().rememberMeParameter("rememberMe");//开启记住我功能 登录页记住我
        System.out.println("-------------------------------------------");
    }

    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select account as 'username',password,true from user u where u.account=?")
                .authoritiesByUsernameQuery("select account as 'username',concat('ROLE_',level) as 'authority' from authority u where u.account=?");
//                .passwordEncoder(new StandardPasswordEncoder("53cr3t"));;
    }

   @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        ExceptionMappingAuthenticationFailureHandler failureHandler = new ExceptionMappingAuthenticationFailureHandler();
        Map<String, String> failureUrlMap = new HashMap<>();
//        failureUrlMap.put(BadCredentialsException.class.getName(), "");
        failureUrlMap.put(CaptchaException.class.getName(),"/login");
//        failureUrlMap.put(LockedException.class.getName(), LoginAuthenticationFailureHandler.LOCKED_URL);
//        failureUrlMap.put(DisabledException.class.getName(), LoginAuthenticationFailureHandler.DISABLED_URL);
        failureHandler.setExceptionMappings(failureUrlMap);
        return failureHandler;
    }

}