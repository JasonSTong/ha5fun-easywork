package club.ha5fun.easywork.dubbo.server.impl;

import club.ha5fun.easywork.dubbo.mapper.TaskTableMapper;
import club.ha5fun.easywork.dubbo.server.TaskTableService;
import club.ha5fun.easywork.dubbo.server.pojo.TaskTable;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chen
 * @Company ha5fun.club
 */
@Transactional
@Service
public class TaskTableResourcesServiceImpl extends BaseServiceImpl implements TaskTableService {
    @Resource
    TaskTableMapper taskTableMapper;
    /**
     *
     * @param taskTable
     * @return -1:输入的参数不符合要求，0：数据插入数据库失败，1：成功
     */
    @Override
    public int saveTaskTableResources(TaskTable taskTable) {
        if (StringUtils.isBlank(taskTable.getTaskInfo())){
            //不符合任务条件
            return -1;
        }
        return super.save(taskTable);
    }

    /**
     *
     * @return List数组
     */
    @Override
    public List<TaskTable> selAllTaskTableResources() {

        return super.queryAll();
    }



    @Override
    public List<TaskTable> selTaskListByWhere(Long notState , String type) {
        TaskTable taskTable = new TaskTable();
        //判断传入的type参数是什么，根据参数选择方法
        if (StringUtils.equals(type,"pullUserId")){
            taskTable.setUserId(notState);
            return super.queryListByWhere(taskTable);
        }else if (StringUtils.equals(type,"pushUserId")){
            taskTable.setUserId(notState);
            return super.queryListByWhere(taskTable);
        }else {
            int state = Math.toIntExact(notState);
            taskTable.setTaskState(state);
            return super.queryListByWhere(taskTable);
        }

    }

    @Override
    public TaskTable selOneTaskById(Long id) {
        return (TaskTable) super.queryById(id);
    }

    @Override
    public Integer changeTaskState(Long taskId ,int taskState,Long userId) {
        TaskTable taskTable = new TaskTable();
        taskTable.setTaskId(taskId);
        taskTable.setTaskState(taskState);
        taskTable.setUserId(userId);
        return super.update(taskTable);
    }

    @Override
    public int addOneTask( TaskTable taskTable) {
        System.out.println(taskTable.getTaskInfo());
        taskTableMapper.addOneTask(taskTable);
        return taskTable.getTaskId().intValue();
    }

}
