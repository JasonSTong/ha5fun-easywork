package club.ha5fun.easywork.dubbo.server;

import club.ha5fun.easywork.dubbo.server.pojo.UserTable;

import java.util.List;
import java.util.Map;

/**
 * @author chen
 * @Company ha5fun.club
 */
public interface UserTableService {
    /***
     * 新增用户
     * @param userTable
     * @return -1：输入的参数不符合要求 ，0：数据插入数据库失败 ，1：数据插入成功
     */
    int saveUserTableResources(UserTable userTable);

    /**
     * 查询用户
     * @param userId
     * @return -1 输入的数据有误 ，0 ：未查到该用户 ，1：查询成功
     */
    UserTable queryUserById(Long userId);


    /**
     *         insertWxUser :微信用户添加
     * @param wxUser
     * @return void
     */
    int insertWxUser(UserTable wxUser);

    /**
     * 根据wxLoginTicket查询用户信息
     * @param wxLoginTicket
     * @return UserTable 返回用户对象
     */
    UserTable selByWXLoginTicket(String wxLoginTicket);

}
