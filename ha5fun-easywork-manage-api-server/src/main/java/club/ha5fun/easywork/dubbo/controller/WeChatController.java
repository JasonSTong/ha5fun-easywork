package club.ha5fun.easywork.dubbo.controller;

import club.ha5fun.easywork.dubbo.server.pojo.IndexTask;
import club.ha5fun.easywork.dubbo.server.pojo.TaskContact;
import club.ha5fun.easywork.dubbo.server.pojo.TaskTable;
import club.ha5fun.easywork.dubbo.service.IndexTableService;
import club.ha5fun.easywork.dubbo.service.TaskContactService;
import club.ha5fun.easywork.dubbo.service.TaskTableService;
import club.ha5fun.easywork.dubbo.service.WeChatService;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chen
 * @Company ha5fun.club
 */

@RequestMapping("wx")
@RestController
public class WeChatController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private WeChatService weChatService;
    @Autowired
    private TaskTableService taskTableService;
    @Autowired
    private TaskContactService taskContactService;
    @Autowired
    private IndexTableService indexTableService;

    @PostMapping("login")
    public Map<String , Object> wxLogin(@RequestParam("nickName") String name ,
                                        @RequestParam("avatarUrl") String url,
                                        @RequestParam("code") String code ){
        return this.weChatService.wxLoginInfo(name, url, code);
    }
    @PostMapping("add")
    public boolean wxAdd(@RequestParam("userId")  Long userId ,
                     @RequestParam("addInputData") String taskInfo ,
                     @RequestParam("tittleData") String taskTittle ,
                     @RequestParam("duration") String taskDuration) throws ParseException {

        //创建一个TaskTable任务  然后写入数据库
        TaskTable taskTable = new TaskTable();
        taskTable.setUserId(userId);
        taskTable.setTaskInfo(taskInfo);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        taskTable.setTaskDuration(sdf.parse(taskDuration));
        taskTable.setTaskTittle(taskTittle);
        //创建一个taskContact 然后写入数据库
        TaskContact taskContact = new TaskContact();
        taskContact.setPushUserId(userId);

        return this.taskContactService.saveTaskContact(taskTable,taskContact);
    }

    @PostMapping("testUpdate")
    public Integer testUpdate(@RequestParam("taskId") Long taskId ,
                              @RequestParam("taskState") int taskState,
                              @RequestParam("userId") Long userId){

        return this.taskContactService.testUpdate(taskId,taskState,userId);
    }

    @PostMapping("changeTaskState")
    public boolean changeTaskState(@RequestParam("taskId") Long taskId ,
                                   @RequestParam("taskState") int taskState,
                                   @RequestParam("userId") Long userId){
        return this.taskTableService.changeTaskState(taskId,taskState ,userId);
    }

    @GetMapping("getUserTaskList")
    public ResponseEntity<String> getUserTaskList(@RequestParam("userId") String id,
                                              @RequestParam("hope") int hope  ){
        List<IndexTask> indexTasks = this.indexTableService.selUserPullList(Long.parseLong(id), hope);
        JSONObject jsonObject = new JSONObject();
        if (indexTasks!=null){
            jsonObject.put("state","200");
            jsonObject.put("data",indexTasks);
        }else {
            jsonObject.put("msg","当前用户为发布或领取任务");
            jsonObject.put("state",10001);
        }
        return ResponseEntity.ok(jsonObject.toJSONString());
    }

}