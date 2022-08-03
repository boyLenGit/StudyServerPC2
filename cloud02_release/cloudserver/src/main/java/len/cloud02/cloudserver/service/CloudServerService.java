package len.cloud02.cloudserver.service;

import len.cloud02.cloudserver.entity.ServerEntity;
import len.cloud02.cloudserver.mapper.CloudServerMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<ServerEntity> getServerList(Integer startIndex, Integer pageSize){
        return cloudServerMapper.getServerList(startIndex, pageSize);
    }


}
