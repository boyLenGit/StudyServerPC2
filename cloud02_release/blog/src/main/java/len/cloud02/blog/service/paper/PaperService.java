package len.cloud02.blog.service.paper;


import len.cloud02.blog.pojo.Paper;
import len.cloud02.blog.pojo.RestString;
import len.cloud02.blog.util.LenLog;
import len.cloud02.blog.util.LenText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class PaperService {
    @Autowired
    private RestTemplate restTemplate;

    public ArrayList<Paper> getPaperList(Pageable pageable){
        String url = "http://paperservice/rest_paper/papers";
        ArrayList<Paper> papers = restTemplate.getForObject(url, ArrayList.class);
        if (papers == null){
            LenLog.info2(getClass(), "getPaperList", "NULL");
        }
        return papers;
    }

    public void addPaper(Paper paper){
        String url = "http://paperservice/rest_paper/admin/add_paper_post";
        restTemplate.postForObject(url, paper, String.class);
    }

    public Paper getPaperById(Long id){
        String url = "http://paperservice/rest_paper/detail/" + id;
        Paper paper = restTemplate.getForObject(url, Paper.class);
        return paper;
    }

    public void updateBook(Long id, Paper paper){
        String url = "http://paperservice/rest_paper/admin/paper_update_post/" + id;
        restTemplate.postForObject(url, paper, String.class);
    }

    public void deleteBook(Long id){
        String url = "http://paperservice/rest_paper/admin/paper_delete/" + id;
        restTemplate.getForObject(url, String.class);
    }

    public ArrayList<Paper> findPapersByOneKeyword(String keyword){
        // keyword传入的时候不需要加%
        keyword = LenText.makeTextUseful(keyword);
        LenLog.info2(getClass(), "findPapersByOneKeyword", keyword);
        String url = "http://paperservice/rest_paper/admin/paper_query/one_keyword";
        ArrayList<Paper> papers = restTemplate.postForObject(url, new RestString(keyword), ArrayList.class);
        if (papers == null){
            LenLog.info2(getClass(), "getPaperList", "NULL");
        }
        return papers;
    }
}
