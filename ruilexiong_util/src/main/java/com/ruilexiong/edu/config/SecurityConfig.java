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
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

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
        http.authorizeRequests().antMatchers("/","/index/**").permitAll()   //主页都可访问
        .antMatchers("/manager/**").hasRole("1"); //管理员管理页面 自动生成会添加前缀ROLE_
        //开启登陆功能
        http.formLogin();
        System.out.println("-------------------------------------------");
    }
    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select account as 'username',password,true from user u where u.account=?")
                .authoritiesByUsernameQuery("select account as 'username',concat('ROLE_',level) as 'authority' from authority u where u.account=?");

//                .passwordEncoder(new StandardPasswordEncoder("53cr3t"));;
    }


}