/**
 * FileName: TaskService
 * Author:   asus
 * Date:     2018/9/10 13:29
 * Description: 调度配置
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruilexiong.edu.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ruilexiong.edu.entity.TaskInfo;
import groovy.util.logging.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈调度配置〉
 *
 * @author asus
 * @create 2018/9/10
 * @since 1.0.0
 */
@Component
@Service  // dubbo服务暴露
@Slf4j
public class TaskServiceImpl implements  TaskService{

    @Autowired
    private Scheduler scheduler;

    private Logger log= LoggerFactory.getLogger("TaskService.class");
    /**
     * 任务列表.
     */
    public List<TaskInfo> list() {

        final List<TaskInfo> list = new ArrayList<>();
        try {
            for (final String groupJob : scheduler.getJobGroupNames()) {
                for (final JobKey jobKey : scheduler.getJobKeys(GroupMatcher.groupEquals(groupJob))) {

                    final List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
                    for (final Trigger trigger : triggers) {
                        final Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
                        final JobDetail jobDetail = scheduler.getJobDetail(jobKey);

                        String cronExpression = "";
                        String createTime = "";

                        if (trigger instanceof CronTrigger) {
                            final CronTrigger cronTrigger = (CronTrigger) trigger;
                            cronExpression = cronTrigger.getCronExpression();
                            createTime = cronTrigger.getDescription();
                        }

                        final TaskInfo info = new TaskInfo();
                        info.setJobName(jobKey.getName());
                        info.setJobGroup(jobKey.getGroup());
                        info.setJobDescription(jobDetail.getDescription());
                        info.setJobStatus(triggerState.name());
                        info.setCronExpression(cronExpression);
                        info.setCreateTime(createTime);
                        info.setJobDataMap(jobDetail.getJobDataMap());
                        list.add(info);
                    }
                }
            }
        } catch (SchedulerException e) {
            log.error("获取任务列表异常", e);
        }

        return list;
    }

    /**
     * 保存定时任务.
     */
    public void addJob(final TaskInfo info) {

        final String jobName = info.jobClass();
        final String jobGroup = info.getJobGroup();
        final String cronExpression = info.getCronExpression();
        final String jobDescription = info.getJobDescription();
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String createTime = dateTimeFormat.format( new Date());
        try {

            if (checkExists(jobName, jobGroup)) {
                log.info("===> AddJob fail, job already exist, jobGroup:{}, jobName:{}", jobGroup, jobName);
                throw new ServiceException(String.format("Job已经存在, jobName:{%s},jobGroup:{%s}", jobName, jobGroup));
            }

            final TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
            final CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression)
                    .withMisfireHandlingInstructionDoNothing();
            final CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(triggerKey)
                    .withDescription(createTime).withSchedule(cronScheduleBuilder).build();

            final Class<? extends Job> clazz = Class.forName(jobName).asSubclass(Job.class);

            final JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
            final JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(jobKey)
                    .withDescription(jobDescription)
                    .usingJobData(info.getJobDataMap())
                    .build();

            scheduler.scheduleJob(jobDetail, cronTrigger);
        } catch (SchedulerException | ClassNotFoundException e) {
            throw new ServiceException("类名不存在或执行表达式错误");
        }
    }

    /**
     * 修改定时任务.
     */
    public void edit(final TaskInfo info) {
        final String jobName = info.jobClass();
        final String jobGroup = info.getJobGroup();
        final String cronExpression = info.getCronExpression();
        final String jobDescription = info.getJobDescription();
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String createTime = dateTimeFormat.format( new Date());

        try {
            if (!checkExists(jobName, jobGroup)) {
                log.info("===> EditJob fail, job already exist, jobGroup:{}, jobName:{}", jobGroup, jobName);
                throw new ServiceException(String.format("Job不存在, jobName:{%s},jobGroup:{%s}", jobName, jobGroup));
            }

            final TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
            final CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression)
                    .withMisfireHandlingInstructionDoNothing();
            final CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(triggerKey)
                    .withDescription(createTime).withSchedule(cronScheduleBuilder).build();

            final JobKey jobKey = new JobKey(jobName, jobGroup);
            final JobBuilder jobBuilder = scheduler.getJobDetail(jobKey).getJobBuilder();

            final JobDetail jobDetail = jobBuilder.usingJobData(info.getJobDataMap()).withDescription(jobDescription).build();

            final Set<Trigger> triggerSet = new HashSet<>();
            triggerSet.add(cronTrigger);

            scheduler.scheduleJob(jobDetail, triggerSet, true);
        } catch (SchedulerException e) {
            throw new ServiceException("类名不存在或执行表达式错误");
        }
    }

    /**
     * 删除定时任务.
     */
    public void delete(final String jobName, final String jobGroup) {
        final TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        try {
            if (checkExists(jobName, jobGroup)) {
                scheduler.pauseTrigger(triggerKey);
                scheduler.unscheduleJob(triggerKey);
                log.info("===> delete, triggerKey:{}", triggerKey);
            }
        } catch (SchedulerException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    /**
     * 暂停定时任务.
     */
    public void pause(final String jobName, final String jobGroup) {
        final TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        try {
            if (checkExists(jobName, jobGroup)) {
                scheduler.pauseTrigger(triggerKey);
                log.info("===> Pause success, triggerKey:{}", triggerKey);
            }
        } catch (SchedulerException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    /**
     * 重新开始任务.
     */
    public void resume(final String jobName, final String jobGroup) {
        final TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        try {
            if (checkExists(jobName, jobGroup)) {
                scheduler.resumeTrigger(triggerKey);
                log.info("===> Resume success, triggerKey:{}", triggerKey);
            }
        } catch (SchedulerException e) {
            log.error("恢复任务时出现异常", e);
        }
    }

    /**
     * 验证是否存在.
     */
    public boolean checkExists(String jobName, String jobGroup) throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        return scheduler.checkExists(triggerKey);
    }


}