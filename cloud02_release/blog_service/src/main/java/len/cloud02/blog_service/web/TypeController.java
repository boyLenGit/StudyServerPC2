package len.cloud02.blog_service.web;

import com.alibaba.fastjson.JSONObject;
import len.cloud02.blog_service.entity.Type;
import len.cloud02.blog_service.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/23 23:59
 */
@Controller
@RequestMapping("/type")
@ResponseBody
public class TypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping("list")
    public JSONObject getTypeList(){
        return typeService.getTypeList();
    }
}
