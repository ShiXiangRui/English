/**
 * FileName: CaptchaException
 * Author:   asus
 * Date:     2018/8/2 9:30
 * Description: 验证码错误异常
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruilexiong.edu.config;

import org.springframework.security.core.AuthenticationException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈验证码错误异常〉
 *
 * @author asus
 * @create 2018/8/2
 * @since 1.0.0
 */
public class CaptchaException extends AuthenticationException {

    public CaptchaException(String msg) {
        super(msg);
    }
}