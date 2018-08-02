/**
 * FileName: ValidateCodeController
 * Author:   asus
 * Date:     2018/8/1 14:09
 * Description: 生成验证码
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruilexiong.edu.controller;

import com.ruilexiong.edu.entity.ValidateCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈生成验证码〉
 *
 * @author asus
 * @create 2018/8/1
 * @since 1.0.0
 */
@RestController
public class ValidateCodeController {

    @GetMapping("/code/image")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ValidateCode vCode = new ValidateCode(108, 37, 4, 70);
        HttpSession session = request.getSession();
        session.setAttribute("code", vCode.getCode());
        vCode.write(response.getOutputStream());
    }
}