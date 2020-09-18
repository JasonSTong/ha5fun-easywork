package club.ha5fun.easywork.dubbo.controller;

import club.ha5fun.easywork.dubbo.server.pojo.IndexTask;
import club.ha5fun.easywork.dubbo.server.pojo.TaskTable;
import club.ha5fun.easywork.dubbo.service.TaskTableService;
import club.ha5fun.easywork.dubbo.service.UserTableService;
import javafx.concurrent.Task;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSONObject;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author chen
 * @Company ha5fun.club
 */
@Controller
@RequestMapping("/wechat")
public class TaskTableController {
    @Autowired
    private TaskTableService taskTableService;


    @PostMapping
    @ResponseBody
    public ResponseEntity<Void> save(@RequestBody TaskTable taskTable){
        try{
            boolean bool = this.taskTableService.save(taskTable);
            if(bool){
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PostMapping(value = "/testSave")
    @ResponseBody
    public ResponseEntity<String> testSave(@RequestParam("userId")  Long userId ,
                                           @RequestParam("addInputData") String taskInfo ,
                                           @RequestParam("tittleData") String taskTittle ,
                                           @RequestParam("duration") String taskDuration) throws ParseException{
        JSONObject jsonObject = new JSONObject();
        //创建一个TaskTable任务  然后写入数据库
        TaskTable taskTable = new TaskTable();
        taskTable.setUserId(userId);
        taskTable.setTaskInfo(taskInfo);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        taskTable.setTaskDuration(sdf.parse(taskDuration));
        taskTable.setTaskTittle(taskTittle);
        int save = this.taskTableService.testSave(taskTable);
        jsonObject.put("返回id",save);
        System.out.println(taskTable.getTaskId());
        return ResponseEntity.ok(jsonObject.toJSONString());
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<String> get(){
        List<TaskTable> taskTables = this.taskTableService.selAll();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("stat","200");
        jsonObject.put("data",taskTables);

        return ResponseEntity.ok(jsonObject.toJSONString());
    }
}
