package len.cloud02.paper_service.dao;

import len.cloud02.common.entity.paper.Paper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface PaperRepository extends JpaRepository<Paper, Long>, JpaSpecificationExecutor {
    @Query("SELECT p FROM paper p WHERE p.name LIKE ?1")
    Page<Paper> findPapersByOneKeyword(Pageable pageable, String keyword);
}
