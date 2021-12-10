package len.cloud01.artifact.dao;

import len.cloud01.artifact.po.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypeRepository extends JpaRepository<Type, Long> {
    Type findByName(String name);

    @Query("select t from t_type t")
    List<Type> LenfindTop(Pageable pageable);  // 按照pageable查询
}
