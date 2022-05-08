package len.cloud02.paper_service.serviec;

import len.cloud02.common.entity.paper.Paper;
import len.cloud02.paper_service.dao.PaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PaperService {
    @Autowired
    private PaperRepository paperRepository;

    public Page<Paper> getBookList(Pageable pageable){
        Page<Paper> articles = paperRepository.findAll(pageable);
        return articles;
    }

}
