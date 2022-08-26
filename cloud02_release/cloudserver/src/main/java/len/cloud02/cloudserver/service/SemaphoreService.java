package len.cloud02.cloudserver.service;

import org.redisson.api.RSemaphore;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/7/31 15:47
 */
@Service
public class SemaphoreService {
    @Autowired
    private RedissonClient redissonClient;

    /**
     * 实质就是让值-1
     */
    public boolean sub(String key) throws InterruptedException {
        RSemaphore rSemaphore = redissonClient.getSemaphore(key);
        return rSemaphore.tryAcquire(5, TimeUnit.SECONDS);
    }

    /**
     * 实质就是让值+1
     */
    public void add(String key){
        RSemaphore rSemaphore = redissonClient.getSemaphore(key);
        rSemaphore.release();
    }
}
