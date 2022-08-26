package len.cloud02.cloudserver.mapper;

import len.cloud02.cloudserver.entity.ServerEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/7/31 16:02
 */
@Repository
public interface CloudServerMapper {
//    void takeServer(String host, String userName);

    List<ServerEntity> getServerList(Integer startIndex, Integer pageSize);

    List<ServerEntity> getServerListNoPage();

    void subServerRemain(Long id);

    ServerEntity getServerById(Long id);
}
