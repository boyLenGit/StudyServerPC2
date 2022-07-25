package len.cloud02.experiment.service;

import len.cloud02.experiment.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/7/25 17:25
 */
@Service
public class RedisService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void testSetJedis(){
        String time = TimeUtils.timestampToYYMMDDHHMMSS(TimeUtils.getNowTimeStamp());
        System.out.println(time);
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set("testJedis", time, 30, TimeUnit.SECONDS);
    }

    public String testGetJedis(){
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        String res = valueOperations.get("testJedis");
        return res;
    }
}
