/**
 * FileName: controller
 * Author:   asus
 * Date:     2018/7/24 17:22
 * Description: 后台管理模块的web入口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruilexiong.edu.manager.controller;

import com.ruilexiong.edu.manager.entity.User;
import com.ruilexiong.edu.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈后台管理模块的web入口〉
 *
 * @author asus
 * @create 2018/7/24
 * @since 1.0.0
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/user/login")
    public String login(){
        return "jsp/a";
    }
    @RequestMapping("user/registe")
    public String registe(){
        List<User> user = userService.getUser();
        for (int i = 0; i <user.size() ; i++) {
            System.out.println(user.get(i));
        }
        return "templates/hello";
    }
}