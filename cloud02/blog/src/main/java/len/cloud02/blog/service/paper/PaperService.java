package len.cloud02.blog.service.paper;

import len.cloud02.common.Util.LenLog;
import len.cloud02.common.Util.LenText;
import len.cloud02.common.entity.helper.PagePaper;
import len.cloud02.common.entity.paper.Paper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
        String url = "http://paperservice/rest_paper/admin/paper_add_post";
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
//
//    public void deleteBook(Long id){
//        paperRepository.deleteById(id);
//    }
//
//    public Page<Paper> findPapersByOneKeyword(Pageable pageable, String keyword){
//        // keyword传入的时候不需要加%
//        keyword = LenText.makeTextUseful(keyword);
//        LenLog.info2(getClass(), "findPapersByOneKeyword", keyword);
//        return paperRepository.findPapersByOneKeyword(pageable, "%"+keyword+"%");
//    }
}
