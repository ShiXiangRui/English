/**
 * FileName: TaskService
 * Author:   asus
 * Date:     2018/9/10 15:03
 * Description: 定时管理接口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruilexiong.edu.service;

import com.ruilexiong.edu.entity.TaskInfo;
import org.quartz.SchedulerException;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈定时管理接口〉
 *
 * @author asus
 * @create 2018/9/10
 * @since 1.0.0
 */
public interface TaskService {

    public abstract List<TaskInfo> list();
    public abstract  void addJob(final TaskInfo info);
    public abstract  void edit(final TaskInfo info);
    public abstract void delete(final String jobName, final String jobGroup);
    public abstract void pause(final String jobName, final String jobGroup);
    public abstract  void resume(final String jobName, final String jobGroup);
    public abstract boolean checkExists(String jobName, String jobGroup) throws SchedulerException;
}