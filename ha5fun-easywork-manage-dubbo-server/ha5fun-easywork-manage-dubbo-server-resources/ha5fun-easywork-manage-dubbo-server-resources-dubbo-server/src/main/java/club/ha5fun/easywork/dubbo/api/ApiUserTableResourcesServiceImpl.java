package club.ha5fun.easywork.dubbo.api;

import club.ha5fun.easywork.dubbo.server.UserTableService;
import club.ha5fun.easywork.dubbo.server.api.ApiUserTableService;
import club.ha5fun.easywork.dubbo.server.pojo.UserTable;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author chen
 * @Company ha5fun.club
 */
@Service(version = "1.0.0")
public class ApiUserTableResourcesServiceImpl  implements ApiUserTableService {
    @Autowired
    private UserTableService userTableService;
    @Override
    public int saveUserTableResources(UserTable userTable) {
        return this.userTableService.saveUserTableResources(userTable);
    }

    @Override
    public UserTable queryUserById(Long userId) {
        System.out.println("ApiUserTableResourcesServiceImpl 执行了");
        return this.userTableService.queryUserById(userId);
    }

    @Override
    public int insertWxUser(UserTable wxUser) {
        return this.userTableService.insertWxUser(wxUser);
    }

    @Override
    public UserTable selByWXLoginTicket(String wxLoginTicket) {
        return this.userTableService.selByWXLoginTicket(wxLoginTicket);
    }
}
