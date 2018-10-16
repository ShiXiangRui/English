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

import com.alibaba.dubbo.config.annotation.Reference;
import com.ruilexiong.edu.entity.TaskInfo;
import com.ruilexiong.edu.service.TaskService;
import com.ruilexiong.edu.service.TestHello;
import com.ruilexiong.edu.service.UserService;
import org.quartz.JobDataMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @Reference
    private UserService userService;
    @Reference
    private TestHello testHello;
    @Reference
    private TaskService taskService;

    @RequestMapping("index/main")
    public String index() {
        return "jsp/index";
    }

    @RequestMapping("login")
    public String toLogin(Map<String, Object> map) {
        return "templates/login";
    }

    @RequestMapping("/index/login")
    public String login() {
        System.out.println("00000000000000000000000000000000000000000");
        return "jsp/index";
    }

    @RequestMapping("/index/hello")
    public String hello() {
        return "templates/hello";

    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello2() {
        System.out.println(userService.getUser());
        return testHello.hello();
    }

    @ResponseBody
    @RequestMapping("/time")
    public String time() {

        System.out.println("添加定时任务");
        TaskInfo taskInfo = new TaskInfo();
        taskInfo.setJobName("com.ruilexiong.edu.service.ScheduleTest");
        taskInfo.setJobGroup("测试1");
        taskInfo.setCronExpression("0 */1 * * * ?");
        taskInfo.setJobDescription("第一次测试");
        taskInfo.setJobDataMap(new JobDataMap());
        taskService.addJob(taskInfo);
        return testHello.hello();
    }

    @ResponseBody
    @RequestMapping("/tstop")
    public String stop() {
        System.out.println("暂停定时任务");
        TaskInfo taskInfo = new TaskInfo();
        taskInfo.setJobName("第一次测试");
        taskInfo.setJobGroup("1");
        taskInfo.setCronExpression("0 */1 * * * ?");
        taskInfo.setJobDescription("第一次测试");
        taskInfo.setJobDataMap(new JobDataMap());
        taskService.pause(taskInfo.getJobName(), taskInfo.getJobGroup());
        return testHello.hello();
    }

    @ResponseBody
    @RequestMapping("/delete")
    public String delete() {
        System.out.println("删除定时任务");
        TaskInfo taskInfo = new TaskInfo();
        taskInfo.setJobName("com.ruilexiong.edu.service.ScheduleTest");
        taskInfo.setJobGroup("测试1");
        taskInfo.setCronExpression("0 */1 * * * ?");
        taskInfo.setJobDescription("第一次测试");
        taskInfo.setJobDataMap(new JobDataMap());
        taskService.delete(taskInfo.getJobName(), taskInfo.getJobGroup());
        return testHello.hello();
    }

}