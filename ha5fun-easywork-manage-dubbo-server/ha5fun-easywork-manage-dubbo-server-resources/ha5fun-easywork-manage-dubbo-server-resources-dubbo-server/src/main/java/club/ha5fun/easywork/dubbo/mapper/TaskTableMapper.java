package club.ha5fun.easywork.dubbo.mapper;

import club.ha5fun.easywork.dubbo.server.pojo.TaskTable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chen
 * @Company ha5fun.club
 */
public interface TaskTableMapper extends BaseMapper<TaskTable> {
    /**
     * 添加一个任务
     * @param taskTable
     * @return 返回添加的任务id
     */
    int addOneTask( TaskTable taskTable);
}
