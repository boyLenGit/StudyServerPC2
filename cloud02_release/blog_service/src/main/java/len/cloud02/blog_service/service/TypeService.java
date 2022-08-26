package len.cloud02.blog_service.service;

import com.alibaba.fastjson.JSONObject;
import len.cloud02.blog_service.entity.Type;
import len.cloud02.blog_service.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/23 23:58
 */
@Service
public class TypeService {
    @Autowired
    private TypeMapper typeMapper;

    public JSONObject getTypeList(){
        List<Type> typeList = typeMapper.getTypeList();
        // 处理结果
        JSONObject result = new JSONObject();
        result.put("list", typeList);
        return result;
    }
}
