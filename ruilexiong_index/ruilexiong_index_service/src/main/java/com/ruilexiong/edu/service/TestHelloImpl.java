/**
 * FileName: TestHelloImpl
 * Author:   asus
 * Date:     2018/8/15 16:10
 * Description: 测试dubbo
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruilexiong.edu.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试dubbo〉
 *
 * @author asus
 * @create 2018/8/15
 * @since 1.0.0
 */
@Component
@Service
public class TestHelloImpl implements  TestHello{

    @Override
    public String hello() {
        return "abcd";
    }
}