package len.cloud02.cloudserver.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/7/28 23:32
 */
@Configuration
public class MyRedisConfig {

    @Value("${spring.redis.host}")
    private String ipAddr;

    // redission通过redissonClient对象使用 // 如果是多个redis集群，可以配置
    @Bean(destroyMethod = "shutdown")
    public RedissonClient redisson() {
        Config config = new Config();
        // 创建单例模式的配置
        config.useSingleServer().setAddress("redis://" + ipAddr + ":6379");
        config.useSingleServer().setPassword("6886526");
        return Redisson.create(config);
    }
}

