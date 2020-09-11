package club.ha5fun.easywork.dubbo.server;

import club.ha5fun.easywork.dubbo.server.pojo.TaskContact;

import java.util.List;

/**
 * @author chen
 * @Company ha5fun.club
 */
public interface TaskContactService {

    /**
     * 查询并返回 不是 1 的所有任务列表
     * @param taskState
     * @return List<TaskContact>返回TaskState不是 1 的所有任务列表
     */
    List<TaskContact> selByNotPull(int taskState);

    /**
     * 根据用户ID查询用户所有  发布的  任务
     * @param pushUserId
     * @return  List<TaskContact>
     */
    List<TaskContact> selByPushUser(Long pushUserId);

    /**
     * 根据用户ID查询用户所有  领取的  任务
     * @param pullUserId
     * @return List<TaskContact>
     */
    List<TaskContact> selByPullUser(Long pullUserId);

    /**
     *  保存 任务联系表
     * @param taskContact
     * @return  -1：输入的参数不符合要求 ，0：数据修改数据库失败 ，1：数据插入成功
     */
    int saveContact(TaskContact taskContact);

    /**
     * 修改任务状态
     * @param taskId
     * @param taskState
     * @return   -1：输入的参数不符合要求 ，0：数据修改数据库失败 ，1：数据插入成功
     */
    Integer changeTaskState(Long taskId , int taskState , Long userId);

    /**
     * 按条件查找
     * @param contact
     * @return List集合
     */
    List<TaskContact> selContact(TaskContact contact);
}
