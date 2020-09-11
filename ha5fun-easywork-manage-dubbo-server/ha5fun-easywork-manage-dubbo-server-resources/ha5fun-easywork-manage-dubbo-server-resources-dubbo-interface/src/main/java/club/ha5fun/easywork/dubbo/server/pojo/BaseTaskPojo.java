package club.ha5fun.easywork.dubbo.server.pojo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author chen
 * @Company ha5fun.club
 */
@Data
public class BaseTaskPojo implements Serializable {
    private static final long serialVersionUID = 4590057786409086472L;
    /**
     * taskPushTime
     * 任务发布时间
     */
    private Date taskPushTime;
    /**
     * taskState
     * 任务状态
     */
    private Integer taskState;
}
