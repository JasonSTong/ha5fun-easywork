package club.ha5fun.easywork.dubbo.controller;

import club.ha5fun.easywork.dubbo.server.pojo.IndexTask;
import club.ha5fun.easywork.dubbo.server.pojo.UserTable;
import club.ha5fun.easywork.dubbo.service.IndexTableService;
import club.ha5fun.easywork.dubbo.service.UserTableService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author chen
 * @Company ha5fun.club
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private IndexTableService indexTableService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<String> get(@RequestParam("hope") int hope){
        List<IndexTask> indexTasks = this.indexTableService.indexTaskList(hope);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("stat","200");
        jsonObject.put("data",indexTasks);

        return ResponseEntity.ok(jsonObject.toJSONString());
    }
}
