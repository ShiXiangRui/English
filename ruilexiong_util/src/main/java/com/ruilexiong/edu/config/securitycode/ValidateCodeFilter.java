/**
 * FileName: ValidateCodeFilter
 * Author:   asus
 * Date:     2018/8/1 17:27
 * Description: 验证码过滤器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruilexiong.edu.config.securitycode;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 〈一句话功能简述〉<br>
 * 〈验证码过滤器〉
 *
 * @author asus
 * @create 2018/8/1
 * @since 1.0.0
 */


public class ValidateCodeFilter extends UsernamePasswordAuthenticationFilter {
    public ValidateCodeFilter() {
        AntPathRequestMatcher requestMatcher = new AntPathRequestMatcher("/index/login", "POST");
        this.setRequiresAuthenticationRequestMatcher(requestMatcher);
        this.setAuthenticationManager(getAuthenticationManager());

    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String requestCaptcha = request.getParameter("yzm");
        String genCaptcha = (String) request.getSession().getAttribute("code");

        if (!genCaptcha.equalsIgnoreCase(requestCaptcha)) {
            request.setAttribute("msg","验证码有误");
//            request.getRequestDispatcher("/login");
            throw new CaptchaException("验证码有误!");
        }
        return super.attemptAuthentication(request, response);
    }
}