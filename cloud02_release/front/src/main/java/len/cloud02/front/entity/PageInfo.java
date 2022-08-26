package len.cloud02.front.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/20 21:18
 */
@Data
public class PageInfo {
    private Integer pageNum;

    private Integer pageSize;

    private Integer pages;

    private Integer size;

    private Integer total;

    public PageInfo(JSONObject jsonObject){
        this.pageNum = (Integer) jsonObject.get("pageNum");
        this.pageSize = (Integer) jsonObject.get("pageSize");
        this.pages = (Integer) jsonObject.get("pages");
        this.size = (Integer) jsonObject.get("size");
        this.total = (Integer) jsonObject.get("total");
    }
}
