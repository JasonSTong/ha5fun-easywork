package club.ha5fun.easywork.dubbo.server.impl;

import club.ha5fun.easywork.dubbo.server.TaskContactService;
import club.ha5fun.easywork.dubbo.server.pojo.TaskContact;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author chen
 * @Company ha5fun.club
 */
@Transactional
@Service
public class TaskContactResourcesServiceImpl extends BaseContactImpl implements TaskContactService {
    @Override
    public List<TaskContact> selByNotPull(int taskState) {
        TaskContact taskContact = new TaskContact();
        taskContact.setTaskState(taskState);
        return super.queryListByWhere(taskContact);
    }

    @Override
    public List<TaskContact> selByPushUser(Long pushUserId) {
        TaskContact taskContact = new TaskContact();
        taskContact.setPushUserId(pushUserId);
        return super.queryListByWhere(taskContact);
    }

    @Override
    public List<TaskContact> selByPullUser(Long pullUserId) {
        TaskContact taskContact = new TaskContact();
        taskContact.setPullUserId(pullUserId);
        return super.queryListByWhere(taskContact);
    }

    @Override
    public int saveContact(TaskContact taskContact) {
        return super.save(taskContact);
    }

    @Override
    public Integer changeTaskState(Long taskId, int taskState,Long userId) {
        TaskContact taskContact = new TaskContact();
        taskContact.setTaskId(taskId);
        taskContact.setTaskState(taskState);
        taskContact.setPullUserId(userId);
        return super.update(taskContact);
    }

    @Override
    public List<TaskContact> selContact(TaskContact contact) {
        return super.queryListByWhere(contact);
    }
}
