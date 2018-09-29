/**
 * FileName: ScheduleTest
 * Author:   asus
 * Date:     2018/9/10 14:38
 * Description: 测试入口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruilexiong.edu.service;

import groovy.util.logging.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试入口〉
 *
 * @author asus
 * @create 2018/9/10
 * @since 1.0.0
 */
@Slf4j
@DisallowConcurrentExecution //注入并发排序依次执行
public class ScheduleTest implements Job {
    private Logger log= LoggerFactory.getLogger("ScheduleTest.class");
        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {
            log.info("JobName: { " + context.getJobDetail().getKey().getName() + "}");
            System.out.println("定时执行");
        }
}