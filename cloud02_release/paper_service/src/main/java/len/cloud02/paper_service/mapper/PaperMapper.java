package len.cloud02.paper_service.mapper;

import len.cloud02.paper_service.pojo.Paper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Mapper
public interface PaperMapper {
    @Select("SELECT * FROM paper p where id=#{id}")
    Paper findById(@Param("id") Long id);
}
