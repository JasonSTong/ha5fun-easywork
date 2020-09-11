package club.ha5fun.easywork.dubbo.service;

import club.ha5fun.easywork.dubbo.server.api.ApiUserTableService;
import club.ha5fun.easywork.dubbo.server.pojo.UserTable;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @author chen
 * @Company ha5fun.club
 * @Date 00000
 */
@Service
public class UserTableService {
    @Reference(version = "1.0.0")
    private ApiUserTableService apiUserTableService;

    public UserTable queryById(Long userId){
        return this.apiUserTableService.queryUserById(userId);
    }
}
