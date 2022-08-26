package len.cloud02.front.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import len.cloud02.front.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/24 00:09
 */
@Service
public class TypeService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${boyLen_blogService_url}")
    private String blogServiceUrl;

    public List<Type> getTypeList(){
        String url = blogServiceUrl + "/type/list";
        JSONObject typeJObj = restTemplate.getForObject(url, JSONObject.class);
        JSONArray jsonArray = typeJObj.getJSONArray("list");
        return jsonArray.toJavaList(Type.class);
    }
}
