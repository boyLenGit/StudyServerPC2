package len.cloud02.blog.service.paper;

import len.cloud02.common.Util.LenLog;
import len.cloud02.common.Util.LenText;
import len.cloud02.common.entity.paper.Paper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
public class PaperService {
    @Autowired
    private RestTemplate restTemplate;

//    public Page<Paper> getPaperList(Pageable pageable){
//        String url = "http://paperservice/geodata/queryById/rest_paper/papers";
//        Page<Paper> paperPage = restTemplate.getForObject(url, Page<Paper>.getClass());
//        return articles;
//    }

//    public void addPaper(Paper paper){
//        paperRepository.save(paper);
//    }

    public Paper getPaperById(Long id){
        String url = "http://paperservice/rest_paper/detail/" + id;
        Paper paper = restTemplate.getForObject(url, Paper.class);
        return paper;
    }

//    @Transactional  // JPA要求，没有事务支持（即没有给方法加@Transactional），不能执行更新和删除操作，会报错”Executing an update/delete query“
//    public Paper updateBook(Long id, Paper book){
//        Paper book_from_sql = getPaperById(id);
//        BeanUtils.copyProperties(book, book_from_sql);
//        return paperRepository.save(book_from_sql);
//    }
//
//    @Transactional  // JPA要求，没有事务支持（即没有给方法加@Transactional），不能执行更新和删除操作，会报错”Executing an update/delete query“
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
