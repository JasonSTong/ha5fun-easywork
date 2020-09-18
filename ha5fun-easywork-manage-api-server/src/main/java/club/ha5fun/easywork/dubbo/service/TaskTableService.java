package club.ha5fun.easywork.dubbo.service;

import club.ha5fun.easywork.dubbo.server.api.ApiTaskContactService;
import club.ha5fun.easywork.dubbo.server.api.ApiTaskTableServer;
import club.ha5fun.easywork.dubbo.server.api.ApiUserTableService;
import club.ha5fun.easywork.dubbo.server.pojo.IndexTask;
import club.ha5fun.easywork.dubbo.server.pojo.TaskContact;
import club.ha5fun.easywork.dubbo.server.pojo.TaskTable;
import club.ha5fun.easywork.dubbo.server.pojo.UserTable;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chen
 * @Company ha5fun.club
 */
@Service
public class TaskTableService {
    @Reference(version = "1.0.0")
    private ApiTaskTableServer apiTaskTableServer;
    @Reference(version = "1.0.0")
    private ApiTaskContactService apiTaskContactService;

    /**
     * 保存上传任务
     * @param taskTable
     * @return
     */
    public boolean save(TaskTable taskTable){
        int result =
                this.apiTaskTableServer.saveTaskTableResources(taskTable);
        return result == 1;
    }
    public int testSave(TaskTable taskTable){
        return this.apiTaskTableServer.addOneTask(taskTable);
    }

    /**
     * 查询所有任务
     * @return
     */
    public List<TaskTable> selAll(){
        return this.apiTaskTableServer.selAllTaskTableResources();
    }

    /**
     * 领取任务 和 释放任务
     * @param taskId
     * @param taskState
     * @return
     */
    public Boolean changeTaskState(Long taskId , int taskState ,Long userId ){
        Integer result = apiTaskTableServer.changeTaskState(taskId, taskState,userId);
        Integer integer = apiTaskContactService.changeTaskState(taskId, taskState,userId);
        if(result.equals(integer)&&integer==1){
            return true ;
        }else {
            return false;
        }
    }

    /**
     * 查询用户领取 或 发布的 任务 Contact
     * @param userId
     * @param hope
     * @return
     */
    public List<TaskContact> userTaskList(Long userId , int hope){
        TaskContact taskContact = new TaskContact();
        if (hope == 1){
            taskContact.setPullUserId(userId);
            taskContact.setTaskState(hope);
        }else if (hope == 0){
            taskContact.setPushUserId(userId);
        }

        return apiTaskContactService.selContact(taskContact);
    }



}
