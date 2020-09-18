package club.ha5fun.easywork.dubbo.service;

import club.ha5fun.easywork.dubbo.server.api.ApiTaskContactService;
import club.ha5fun.easywork.dubbo.server.api.ApiTaskTableServer;
import club.ha5fun.easywork.dubbo.server.api.ApiUserTableService;
import club.ha5fun.easywork.dubbo.server.pojo.TaskContact;
import club.ha5fun.easywork.dubbo.server.pojo.TaskTable;
import club.ha5fun.easywork.dubbo.server.pojo.UserTable;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author chen
 * @Company ha5fun.club
 */
@Service
public class TaskContactService {
    @Reference(version = "1.0.0")
    private ApiUserTableService apiUserTableService;
    @Reference(version = "1.0.0")
    private ApiTaskTableServer apiTaskTableServer;
    @Reference(version = "1.0.0")
    private ApiTaskContactService apiTaskContactService;

    //查询没有呗领取的任务  taskState == 0

    /**
     *
     * @param taskState
     * @return 返回查找出的 List
     */
    public List<TaskContact> selByNotPull(int taskState){
        return apiTaskContactService.selByNotPull(taskState);
    };

    public Boolean saveTaskContact(TaskTable taskTable , TaskContact taskContact){
        int result = 0;

        int taskId = this.apiTaskTableServer.addOneTask(taskTable);
        System.out.println(taskId);
        taskContact.setTaskId((long) taskId);
        System.out.println(taskId);
        int contactResult = this.apiTaskContactService.saveContact(taskContact);

        if(contactResult == 1 ){
            result = 1;
        }
        return result == 1 ;
    }
    public Integer testUpdate( Long taskId ,
                               int taskState,
                              Long userId){

        return apiTaskContactService.changeTaskState(taskId,taskState,userId);
    }
}
