package len.cloud02.front.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import len.cloud02.front.entity.Blog;
import len.cloud02.front.entity.PageInfo;
import len.cloud02.front.entity.Paper;
import len.cloud02.front.service.IndexService;
import len.cloud02.front.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/19 22:49
 */
@Controller
public class IndexController {
    @Autowired
    private IndexService indexService;

    @Autowired
    private PaperService paperService;

    @GetMapping("/")
    public String index(Model model){
        return "index";
    }

    @PostMapping("/index/paper")
    public String paper(Model model){
        List<Paper> paperList = paperService.getPaperList();
        model.addAttribute("papers", paperList);
        return "index :: paperList";
    }

    @PostMapping("/index/blog")
    public String blog(Model model){
        JSONObject jsonObject = indexService.getBlogList(1, 10);
        JSONArray jsonArray = jsonObject.getJSONArray("list");
        List<Blog> blogList = jsonArray.toJavaList(Blog.class);
        PageInfo pageInfo = new PageInfo(jsonObject);
        model.addAttribute("page", pageInfo);
        model.addAttribute("blogs", blogList);
        return "index :: blogList";
    }
}
