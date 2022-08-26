package len.cloud02.cloudserver.service;

import len.cloud02.cloudserver.entity.ServerEntity;
import len.cloud02.cloudserver.mapper.CloudServerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/7/31 15:50
 */
@Service
public class CloudServerService {
    @Autowired
    private CloudServerMapper cloudServerMapper;

    @Autowired
    private SemaphoreService semaphoreService;

    @Autowired
    private RedisService redisService;

    @Value("${boyLen.serverUUID}")
    private String SERVER_UUID;

    public List<ServerEntity> getServerList(Integer startIndex, Integer pageSize){
        return cloudServerMapper.getServerList(startIndex, pageSize);
    }

    public ServerEntity takeAServer(String host, Long id) throws InterruptedException {
        String serverUUID = SERVER_UUID + host +  "_" + id;
        if (semaphoreService.sub(serverUUID)){
            cloudServerMapper.subServerRemain(id);
            return cloudServerMapper.getServerById(id);
        }
        return null;
    }

    /**
     * *************** TEST ***************
     */
    public ServerEntity getServerById(Long id){
        return cloudServerMapper.getServerById(id);
    }
}
