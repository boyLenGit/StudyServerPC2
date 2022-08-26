package len.cloud02.front.entity;

import lombok.Data;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/21 12:21
 */
@Data
public class Param {
    private String name;

    private Object body;

    public Param(String name, Object body){
        this.name = name;
        this.body = body;
    }
}
