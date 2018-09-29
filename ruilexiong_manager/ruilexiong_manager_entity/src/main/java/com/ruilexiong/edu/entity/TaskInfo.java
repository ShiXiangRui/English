/**
 * FileName: TaskInfo
 * Author:   asus
 * Date:     2018/9/10 13:31
 * Description: 任务实体
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruilexiong.edu.entity;

import groovy.transform.builder.Builder;
import org.quartz.JobDataMap;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈任务实体〉
 *
 * @author asus
 * @create 2018/9/10
 * @since 1.0.0
 */
@Builder

public class TaskInfo implements Serializable {

    private JobDataMap jobDataMap;

    // 任务名称

    private String jobName;

    //任务分组

    private String jobGroup;

    //任务描述

    private String jobDescription;

    //任务状态

    private String jobStatus;

    //任务表达式

    private String cronExpression;

    //生成任务时间
    private String createTime;

    public String jobClass() {
        return jobName == null ? null : jobName.split("#")[0];
    }

    public JobDataMap getJobDataMap() {
        return jobDataMap;
    }

    public void setJobDataMap(JobDataMap jobDataMap) {
        this.jobDataMap = jobDataMap;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

}