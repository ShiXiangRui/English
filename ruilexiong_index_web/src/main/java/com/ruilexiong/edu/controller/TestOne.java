/**
 * FileName: TestOne
 * Author:   asus
 * Date:     2018/7/27 14:07
 * Description: 测试一
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruilexiong.edu.controller;

import com.ruilexiong.edu.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试一〉
 *
 * @author asus
 * @create 2018/7/27
 * @since 1.0.0
 */
@Controller
public class TestOne {

    private UserService userService;
    @RequestMapping("index/main")
    public String index(){
            return "jsp/index";
    }
    @RequestMapping("login")
    public String toLogin(Map<String,Object> map){
        return "templates/login";
    }
 /* @RequestMapping("/index/login")
    public String login(){
        System.out.println("00000000000000000000000000000000000000000");
        return "jsp/index";
    }*/
    @RequestMapping("/index/hello")
    public String hello(){
        return "templates/hello";
    }

}