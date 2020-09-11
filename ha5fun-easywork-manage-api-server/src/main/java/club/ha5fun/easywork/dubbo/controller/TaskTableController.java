package club.ha5fun.easywork.dubbo.controller;

import club.ha5fun.easywork.dubbo.server.pojo.IndexTask;
import club.ha5fun.easywork.dubbo.server.pojo.TaskTable;
import club.ha5fun.easywork.dubbo.service.TaskTableService;
import club.ha5fun.easywork.dubbo.service.UserTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSONObject;

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
