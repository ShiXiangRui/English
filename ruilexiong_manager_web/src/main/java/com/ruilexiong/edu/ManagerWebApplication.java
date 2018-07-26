/**
 * FileName: ManagerWebApplication
 * Author:   asus
 * Date:     2018/7/24 17:24
 * Description: springboot入口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruilexiong.edu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 〈一句话功能简述〉<br> 
 * 〈springboot入口〉
 *
 * @author asus
 * @create 2018/7/24
 * @since 1.0.0
 */
@SpringBootApplication
public class ManagerWebApplication {
        private static Logger logger= LoggerFactory.getLogger("ManagerWebApplication.class");


        public static void main(String[] args) {
            SpringApplication.run(ManagerWebApplication.class, args);
            logger.info("项目启动...");
            logger.error("测试");
            logger.debug("cac");
            logger.trace("trace");
            logger.warn("warn");

        }
}