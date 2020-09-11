package club.ha5fun.easywork.dubbo.api;

import club.ha5fun.easywork.dubbo.server.TaskTableService;
import club.ha5fun.easywork.dubbo.server.api.ApiTaskTableServer;
import club.ha5fun.easywork.dubbo.server.pojo.IndexTask;
import club.ha5fun.easywork.dubbo.server.pojo.TaskTable;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * dubbo-service
 * @author chen
 * @Company ha5fun.club
 */
@Service(version = "1.0.0")
public class ApiTaskTableResourcesServiceImpl implements ApiTaskTableServer {
    @Autowired
    private TaskTableService taskTableService;
    @Override
    public int saveTaskTableResources(TaskTable taskTable) {

        return this.taskTableService.saveTaskTableResources(taskTable);
    }

    @Override
    public List<TaskTable> selAllTaskTableResources() {

        return taskTableService.selAllTaskTableResources();
    }


    @Override
    public List<TaskTable> selTaskListByWhere(Long notState , String type) {
        return taskTableService.selTaskListByWhere(notState,type);
    }

    @Override
    public TaskTable selOneTaskById(Long id) {
        return taskTableService.selOneTaskById(id);
    }

    @Override
    public Integer changeTaskState(Long taskId , int taskState , Long userId) {

        return taskTableService.changeTaskState(taskId,taskState,userId);
    }



}
