package len.cloud02.front.service;



import com.alibaba.fastjson.JSONObject;
import len.cloud02.front.entity.Paper;
import len.cloud02.front.entity.Param;
import len.cloud02.front.utils.HttpClientUtils;
import len.cloud02.front.utils.LenLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaperService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${boyLen_paperService_url}")
    private String paperServiceUrl;

    public List<Paper> getPaperList(){
        String url = paperServiceUrl + "/rest_paper/papers";
        ArrayList<Paper> papers = restTemplate.getForObject(url, ArrayList.class);
        if (papers == null){
            LenLog.info2(getClass(), "getPaperList", "NULL");
        }
        return papers;
    }

    public JSONObject getPaperList(Integer pageNum, Integer pageSize){
        // 生成URL
        String url = paperServiceUrl + "/rest_paper/papersJObj";
        url += HttpClientUtils.paramsToUrl(new Param("pageNum", pageNum), new Param("pageSize", pageSize));
        // 处理结果
        return restTemplate.getForObject(url, JSONObject.class);
    }

    public void addPaper(Paper paper){
        String url = paperServiceUrl + "/rest_paper/admin/add_paper_post";
        restTemplate.postForObject(url, paper, String.class);
    }

    public Paper getPaperById(Long id){
        String url = paperServiceUrl + "/rest_paper/detail/" + id;
        Paper paper = restTemplate.getForObject(url, Paper.class);
        return paper;
    }

    public void updateBook(Long id, Paper paper){
        String url = paperServiceUrl + "/rest_paper/admin/paper_update_post/" + id;
        restTemplate.postForObject(url, paper, String.class);
    }

    public void deleteBook(Long id){
        String url = paperServiceUrl + "/rest_paper/admin/paper_delete/" + id;
        restTemplate.getForObject(url, String.class);
    }

//    public ArrayList<Paper> findPapersByOneKeyword(String keyword){
//        // keyword传入的时候不需要加%
//        keyword = LenText.makeTextUseful(keyword);
//        LenLog.info2(getClass(), "findPapersByOneKeyword", keyword);
//        String url = "http://paperservice/rest_paper/admin/paper_query/one_keyword";
//        ArrayList<Paper> papers = restTemplate.postForObject(url, new RestString(keyword), ArrayList.class);
//        if (papers == null){
//            LenLog.info2(getClass(), "getPaperList", "NULL");
//        }
//        return papers;
//    }
}
