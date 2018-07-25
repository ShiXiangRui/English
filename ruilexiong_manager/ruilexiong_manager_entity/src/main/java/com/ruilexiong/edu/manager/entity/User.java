/**
 * FileName: User
 * Author:   asus
 * Date:     2018/7/25 16:13
 * Description: 用户对象
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruilexiong.edu.manager.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈用户对象〉
 *
 * @author asus
 * @create 2018/7/25
 * @since 1.0.0
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增
    private Integer userId ;
    private Integer  phone;
    private Integer  age;
    private String userName  ;
    private String password  ;
    private String account;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {

        this.account = account;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", phone=" + phone +
                ", age=" + age +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", account='" + account + '\'' +
                '}';
    }
}