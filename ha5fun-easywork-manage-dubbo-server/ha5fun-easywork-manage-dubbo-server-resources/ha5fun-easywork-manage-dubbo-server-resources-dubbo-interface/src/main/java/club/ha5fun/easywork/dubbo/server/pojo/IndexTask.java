package club.ha5fun.easywork.dubbo.server.pojo;

import lombok.Data;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author chen
 * @Company ha5fun.club
 */
@Data
public class IndexTask{

    /**
     * taskPushTime
     * 任务发布时间
     */
    private String taskPushTime;

    private Long taskId;
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
    private String taskDuration;
    /**
     * 任务状态
     */
    private Integer taskState;

}
