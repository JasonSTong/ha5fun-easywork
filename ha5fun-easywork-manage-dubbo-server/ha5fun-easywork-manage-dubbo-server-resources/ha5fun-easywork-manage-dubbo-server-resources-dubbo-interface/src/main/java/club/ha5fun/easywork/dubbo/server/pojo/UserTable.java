package club.ha5fun.easywork.dubbo.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author chen
 * @Company ha5fun.club
 */
@Data
public class UserTable extends BaseUserPojo{
    /**
     * 用户ID
     */
    @TableId(value = "user_id" , type = IdType.AUTO)
    private Long userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户头像
     */
    private String userImg;
    /**
     * 微信登录ticket
     */
    private String wxLoginTicket;
}
