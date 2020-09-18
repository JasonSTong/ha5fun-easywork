package club.ha5fun.easywork.dubbo.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @author chen
 * @Company ha5fun.club
 */
@Data
public class TaskContact extends BaseTaskContactPojo {
    /**
     * 任务接收人ID
     */
    private Long pullUserId;
    /**
     * 任务ID
     */
    private Long taskId;
    /**
     * 任务发布者ID
     */
    private Long pushUserId;
    /**
     * 任务状态
     */
    private int taskState;
    /**
     * 乐观锁
     */
    @Version
    private Integer version;
}
