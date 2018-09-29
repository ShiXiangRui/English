/**
 * FileName: QuartzConfig
 * Author:   asus
 * Date:     2018/9/10 11:33
 * Description: quartz定时配置文件
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruilexiong.edu.service;

import groovy.util.logging.Slf4j;
import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import org.apache.tomcat.jdbc.pool.DataSource;import java.io.IOException;
import java.util.Properties;

/**
 * 〈一句话功能简述〉<br> 
 * 〈quartz定时配置文件〉
 *
 * @author asus
 * @create 2018/9/10
 * @since 1.0.0
 */
@Configuration
@Slf4j
public class QuartzConfig {

    @Autowired
    private SpringJobFactory springJobFactory;
    @Autowired
    private DataSource dataSource;

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
        final SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setJobFactory(springJobFactory);
        schedulerFactoryBean.setQuartzProperties(quartzProperties());
        schedulerFactoryBean.setDataSource(dataSource);
        return schedulerFactoryBean;


    }
    @Bean
    public Scheduler scheduler() throws IOException {
        return schedulerFactoryBean().getScheduler();
    }

    private Properties quartzProperties() throws IOException {
        final PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("quartz.properties"));
        Properties properties = null;

        try {
            propertiesFactoryBean.afterPropertiesSet();
            properties = propertiesFactoryBean.getObject();
        } catch (IOException e) {
            Logger logger= LoggerFactory.getLogger("QuartzConfig.class");
            logger.error("读取quartz.properties失败", e);
        }
        return properties;
    }
}