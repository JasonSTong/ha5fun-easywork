package club.ha5fun.easywork.dubbo.server;

import club.ha5fun.easywork.dubbo.server.pojo.IndexTask;
import club.ha5fun.easywork.dubbo.server.pojo.TaskTable;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chen
 * @Company ha5fun.club
 */
public interface TaskTableService {
    /***
     * 新增任务
     * @param taskTable
     * @return -1：输入的参数不符合要求 ，0：数据插入数据库失败 ，1：数据插入成功
     */
    int saveTaskTableResources(TaskTable taskTable);

    /**
     *  查询全部的任务信息
     * @return List<TaskTable>
     */
    List<TaskTable> selAllTaskTableResources();

    /**
     * 根据非状态值 查询相关所有任务
     * @param notState
     * @param type
     * @return
     */
    List<TaskTable> selTaskListByWhere(Long notState , String type);

    /**
     * 返回一个TaskTable的对象
     * @param id
     * @return   一条TaskTable信息
     */
    TaskTable selOneTaskById(Long id);
    /**
     * 修改任务状态
     * @param taskId
     * @param taskState
     * @return   -1：输入的参数不符合要求 ，0：数据修改数据库失败 ，1：数据插入成功
     */
    Integer changeTaskState(Long taskId , int taskState,Long userId);

    /**
     * 添加一个任务
     * @param taskTable
     * @return 返回添加的任务id
     */
    int addOneTask(TaskTable taskTable);

}
