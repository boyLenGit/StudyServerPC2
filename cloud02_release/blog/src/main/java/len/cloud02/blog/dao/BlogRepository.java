package len.cloud02.blog.dao;

import len.cloud02.blog.pojo.Blog;
import len.cloud02.blog.pojo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// JpaSpecificationExecutor用于实现动态组合查询功能
public interface BlogRepository extends JpaRepository<Blog, Long>, JpaSpecificationExecutor<Blog> {

    @Query("SELECT b from t_blog b where b.recommend=true")
    List<Blog> LenfindTop(Pageable pageable);

    // SQL模糊处理语句：select * from t_blog where title like '%内容%';  其中内容就是要模糊查询的内容。这里采用在query中先加上%，不在SQL语句中加%
    @Query("select blog from t_blog blog where blog.title like ?1 or blog.content like ?1")
    Page<Blog> findByQuery(String query, Pageable pageable);

    @Modifying // ← 因为update是修改，因此要加上这个注解
    @Query("update t_blog blog set blog.views = blog.views + 1 where blog.id = ?1")
    int updateViews(Long id);

    @Query("SELECT b FROM t_blog b WHERE b.user=?1")
    Page<Blog> findByUser(User user, Pageable pageable);

//    @Query("SELECT b FROM t_blog b WHERE b.user=?1")
//    Page<Blog> findByUserNoPage(User user);
}
