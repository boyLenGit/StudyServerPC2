package len.cloud02.experiment.controller;

import len.cloud02.experiment.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/7/25 17:44
 */
@Controller
@RequestMapping("/redis")
@ResponseBody
public class RedisController {
    @Autowired
    private RedisService redisService;

    @GetMapping("/testSetJedis")
    public String testSetJedis(){
        redisService.testSetJedis();
        return "OK";
    }

    @GetMapping("/testGetJedis")
    public String testGetJedis(){
        return redisService.testGetJedis();
    }
}
