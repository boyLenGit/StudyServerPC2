package len.cloud02.blog.dao;

import len.cloud02.blog.pojo.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findByName(String name);

    @Query("SELECT t from t_tag t")
    List<Tag> LenfindTop(Pageable pageable);
}
