package len.cloud02.cloudserver.service;

import len.cloud02.cloudserver.entity.ServerEntity;
import len.cloud02.cloudserver.mapper.CloudServerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/5 13:07
 */
@Service
public class BootService {
    @Autowired
    private CloudServerMapper cloudServerMapper;

    @Autowired
    private RedisService redisService;

    @Value("${boyLen.serverUUID}")
    private String SERVER_UUID;

    public void syncRedis(){
        List<ServerEntity> serverEntityList = cloudServerMapper.getServerListNoPage();
        for (ServerEntity item: serverEntityList){
            String serverUUID = SERVER_UUID + item.getHost() + "_" + item.getId();
            redisService.set(serverUUID, String.valueOf(item.getRemain()));
        }
    }
}
