package len.cloud02.paper_service.dao;

import len.cloud02.common.entity.paper.Paper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PaperRepository extends JpaRepository<Paper, Long>, JpaSpecificationExecutor {

}
