/**
 * FileName: controller
 * Author:   asus
 * Date:     2018/7/24 17:22
 * Description: 后台管理模块的web入口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruilexiong.edu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ruilexiong.edu.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @Reference
    private UserService userService;
    @RequestMapping("/login")
    public String login(){
        return "templates/login";
    }
    @RequestMapping("/index/login")
    public String toIndex(){
        return "templates/main";
    }


}