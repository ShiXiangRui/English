/**
 * FileName: controller
 * Author:   asus
 * Date:     2018/7/24 17:22
 * Description: 后台管理模块的web入口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruilexiong.edu.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ruilexiong.edu.entity.User;
import com.ruilexiong.edu.mapping.UserMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 〈一句话功能简述〉<br> 
 * 〈后台管理模块的web入口〉
 *
 * @author asus
 * @create 2018/7/24
 * @since 1.0.0
 */
@Component
@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private UserMapping userMapping;
    @Override
    public List<User> getUser() {
        return userMapping.findAll();
    }


}