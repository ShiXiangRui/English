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

    @RequestMapping("index/a")
    public String login(){
            return "jsp/index";
    }
    @RequestMapping("index/b")
    public String registe(Map<String,Object> map){
        map.put("user","a");
        return "templates/login";
    }
}