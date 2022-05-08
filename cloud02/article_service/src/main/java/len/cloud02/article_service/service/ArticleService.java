package len.cloud02.article_service.service;

import len.cloud02.article_service.dao.ArticleRepository;
import len.cloud02.article_service.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public Page<Article> getBookList(Pageable pageable){
        Page<Article> articles = articleRepository.findAll(pageable);
        return articles;
    }
}
