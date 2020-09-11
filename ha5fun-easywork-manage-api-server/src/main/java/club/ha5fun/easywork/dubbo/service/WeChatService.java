package club.ha5fun.easywork.dubbo.service;

import club.ha5fun.easywork.dubbo.server.api.ApiUserTableService;
import club.ha5fun.easywork.dubbo.server.pojo.UserTable;
import com.alibaba.dubbo.config.annotation.Reference;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chen
 * @Company ha5fun.club
 */
@Service
public class WeChatService {

    @Autowired
    private RestTemplate restTemplate;
    @Reference(version = "1.0.0")
    private ApiUserTableService apiUserTableService;


    /**
     * 用户code 校验
     * @param code
     * @return 返回状态码
     */
    public Map<String , Object> wxLogin(String code){

        Map<String, Object> result = new HashMap<>();
        result.put("status",200);


        String appId = "wx9a886bd40e8fb753";
        String secret = "097fec49a57438eac529acb18c9d88e5";
        String url = "https://api.weixin.qq.com/sns/jscode2session?"
                +"appid="+appId
                +"&secret=" +secret
                +"&js_code="+code
                +"&grant_type=authorization_code";
        //http请求
        String jsonData = this.restTemplate.getForObject(url, String.class);
        //判断返回的json字符串是否有errorcode
        if(StringUtils.contains(jsonData,"errorcode")){
            result.put("status",500);
            result.put("msg","登陆失败");
            return result;
        }
        String md5Key = DigestUtils.md5Hex(jsonData+"EASY_WORK_LOGIN");
        result.put("ticket","ha5fun_"+md5Key);

        return result;
    }

    /**
     *验证用户登录
     *
     * @param name
     * @param url
     * @param code
     * @return userLoginInfo  返回用户name 头像的url 生成的用户唯一key 用户id
     */
    public Map<String , Object> wxLoginInfo( String name ,
                                             String url,
                                             String code ){

        //重新装配
        Map<String, Object> userLoginInfo = new HashMap<>();
        Map<String, Object> result = wxLogin(code);

        //返回状态码
        userLoginInfo.put("status",result.get("status"));
        userLoginInfo.put("ticket",result.get("ticket"));
        userLoginInfo.put("userImg",url);

        //add进数据库
        UserTable userTable = new UserTable();
        userTable.setUserName(name);
        userTable.setUserImg(url);
        userTable.setWxLoginTicket(String.valueOf(result.get("ticket")));
        System.out.println(userLoginInfo);

        apiUserTableService.insertWxUser(userTable);

        //根据WxLoginTicket查询用户ID
        UserTable userTable1 = apiUserTableService.selByWXLoginTicket((String) result.get("ticket"));
        userLoginInfo.put("userId",userTable1.getUserId());

        return userLoginInfo;
    }



}
