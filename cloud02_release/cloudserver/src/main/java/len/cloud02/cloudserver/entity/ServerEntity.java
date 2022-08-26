package len.cloud02.cloudserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/7/31 15:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServerEntity {
    private Long id;
    private String host;
    private String port;
    private String userName;
    private String password;
    private String name;
    private Integer total;
    private Integer remain;
    private Integer cpuCore;
    private Long ramSize;
    private Long diskSize;
}
