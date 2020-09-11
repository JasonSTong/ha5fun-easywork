package club.ha5fun.easywork.dubbo.server.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;




/**
 * @author chen
 * @Company ha5fun.club
 */
@Data
public class TaskTable extends BaseTaskPojo{

    @TableId(value = "task_id" , type = IdType.AUTO)
    private Long taskId;
    private Long userId;
    /**
     * 任务信息
     */
    private String taskInfo;
    /**
     * 任务标题
     */
    private String taskTittle;
    /**
     * 任务持续时长
     */
    private Date taskDuration;
    /**
     * 任务状态
     */
    private Integer taskState = 1;

    /**
     * 乐观锁
     */
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

}
