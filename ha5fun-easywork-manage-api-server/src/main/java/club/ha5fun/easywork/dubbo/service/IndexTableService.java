package club.ha5fun.easywork.dubbo.service;

import club.ha5fun.easywork.dubbo.server.api.ApiTaskContactService;
import club.ha5fun.easywork.dubbo.server.api.ApiTaskTableServer;
import club.ha5fun.easywork.dubbo.server.api.ApiUserTableService;
import club.ha5fun.easywork.dubbo.server.pojo.IndexTask;
import club.ha5fun.easywork.dubbo.server.pojo.TaskContact;
import club.ha5fun.easywork.dubbo.server.pojo.TaskTable;
import club.ha5fun.easywork.dubbo.server.pojo.UserTable;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chen
 * @Company ha5fun.club
 */
@Service
public class IndexTableService {

    @Reference(version = "1.0.0")
    private ApiUserTableService apiUserTableService;
    @Reference(version = "1.0.0")
    private ApiTaskTableServer apiTaskTableServer;
    @Reference(version = "1.0.0")
    private ApiTaskContactService apiTaskContactService;
    @Autowired
    private TaskTableService taskTableService;


    /**
     *  装配 新的 indexList
     * @param taskContacts
     * @return
     */
    private List<IndexTask> slotsList(List<TaskContact> taskContacts ){
        List<IndexTask> indexTasks = new ArrayList<>();


        for (int i = 0; i < taskContacts.size(); i++) {
            Long pushUserId = taskContacts.get(i).getPushUserId();
            System.out.println("拿到了UserId"+pushUserId);

            UserTable userTable = apiUserTableService.queryUserById(pushUserId);
            System.out.println("根据UserID拿到了UserTable"+userTable);

            Long taskId = taskContacts.get(i).getTaskId();
            System.out.println("拿到了taskId"+taskId);

            TaskTable taskTable = apiTaskTableServer.selOneTaskById(taskId);
            System.out.println("根据taskId拿到了taskTable"+taskTable);



            IndexTask indexTask = new IndexTask();

            indexTask.setUserName(userTable.getUserName());
            indexTask.setUserImg(userTable.getUserImg());
            indexTask.setUserId(userTable.getUserId());

            indexTask.setTaskId(taskId);
            indexTask.setTaskTittle(taskTable.getTaskTittle());
            indexTask.setTaskState(taskTable.getTaskState());

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            indexTask.setTaskDuration(simpleDateFormat.format(taskTable.getTaskDuration()));
            indexTask.setTaskInfo(taskTable.getTaskInfo());

            indexTask.setTaskPushTime(simpleDateFormat.format(taskTable.getTaskPushTime()));

            indexTasks.add(indexTask);
        }

        return indexTasks;
    }


    /**
     * 实现首页任务列表
     * 将查询到的所有taskTable 和 userTable组装成indexTask的List
     * @return List<IndexTask>
     */
    public List<IndexTask> indexTaskList(int whatever){

        //返回的一个List
        List<TaskContact> taskContacts = apiTaskContactService.selByNotPull(whatever);
        return this.slotsList(taskContacts);
    }

    /**
     * 查询 用户的 Pull OR Push List
     * @param userId
     * @param hope
     * @return
     */
    public List<IndexTask> selUserPullList(Long userId, int hope){
        List<TaskContact> taskContacts = taskTableService.userTaskList(userId, hope);
        return this.slotsList(taskContacts);
    }
}
