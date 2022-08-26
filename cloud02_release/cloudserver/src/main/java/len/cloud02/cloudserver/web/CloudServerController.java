package len.cloud02.cloudserver.web;

import com.alibaba.fastjson.JSONObject;
import len.cloud02.cloudserver.entity.ServerEntity;
import len.cloud02.cloudserver.service.CloudServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/7/31 15:47
 */
@Controller
@RequestMapping("/server/json/")
@ResponseBody
public class CloudServerController {
    @Autowired
    private CloudServerService cloudServerService;

    @GetMapping("/getlist")
    public JSONObject getServerList(){
        List<ServerEntity> serverEntityList = cloudServerService.getServerList(0, 10);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("list", serverEntityList);
        return jsonObject;
    }

    @GetMapping("/takeServer")
    public JSONObject takeServer(@RequestParam Long id, @RequestParam String host) throws InterruptedException {
        ServerEntity server = cloudServerService.takeAServer(host, id);
        JSONObject jsonObject = new JSONObject();
        if (server != null){
            jsonObject.put("server", server);
            jsonObject.put("message", true);
        }else {
            jsonObject.put("server", server);
            jsonObject.put("message", false);
        }
        return jsonObject;
    }
}
