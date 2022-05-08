package len.cloud02.article_service.dao;

import len.cloud02.common.entity.article.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface ArticleRepository extends JpaRepository<Article, Long>, JpaSpecificationExecutor {

}
