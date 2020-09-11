package club.ha5fun.easywork.dubbo.server.impl;

import club.ha5fun.easywork.dubbo.server.UserTableService;
import club.ha5fun.easywork.dubbo.server.pojo.BaseUserPojo;
import club.ha5fun.easywork.dubbo.server.pojo.UserTable;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author chen
 * @Company ha5fun.club
 */

@Transactional

@Service
public class UserTableResourcesServiceImpl extends BaseUserServiceImpl implements UserTableService {
    @Override
    public int saveUserTableResources(UserTable userTable) {
        if (StringUtils.isBlank(userTable.getUserName())){
            //不符合任务条件
            return -1;
        }
        return super.save(userTable);
    }

    @Override
    public UserTable queryUserById(Long userId) {
        return (UserTable) super.queryById(userId);
    }

    @Override
    public int insertWxUser(UserTable wxUser) {
        return super.save(wxUser);
    }

    @Override
    public UserTable selByWXLoginTicket(String wxLoginTicket) {
        UserTable userTable = new UserTable();
        userTable.setWxLoginTicket(wxLoginTicket);
        return (UserTable) super.queryOne(userTable);
    }
}
