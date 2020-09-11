package club.ha5fun.easywork.dubbo.api;

import club.ha5fun.easywork.dubbo.server.TaskContactService;
import club.ha5fun.easywork.dubbo.server.api.ApiTaskContactService;
import club.ha5fun.easywork.dubbo.server.impl.TaskContactResourcesServiceImpl;
import club.ha5fun.easywork.dubbo.server.pojo.TaskContact;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author chen
 * @Company ha5fun.club
 */
@Service(version = "1.0.0")
public class ApiTaskContactResourceServiceImpl implements ApiTaskContactService {

    @Autowired
    private TaskContactService taskContactService;

    @Override
    public List<TaskContact> selByNotPull(int taskState) {
        return this.taskContactService.selByNotPull(taskState);
    }

    @Override
    public List<TaskContact> selByPushUser(Long pushUserId) {
        return this.taskContactService.selByPushUser(pushUserId);
    }

    @Override
    public List<TaskContact> selByPullUser(Long pullUserId, String type) {
        return null;
    }

    @Override
    public int saveContact(TaskContact taskContact) {
        return this.taskContactService.saveContact(taskContact);
    }

    @Override
    public Integer changeTaskState(Long taskId, int taskState , Long userId) {
        return this.taskContactService.changeTaskState(taskId,taskState,userId);
    }

    @Override
    public List<TaskContact> selContact(TaskContact contact) {
        return this.taskContactService.selContact(contact);
    }

}
