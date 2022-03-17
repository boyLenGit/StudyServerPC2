package len.cloud02.geodata.gd_service.mapper;

import len.cloud02.geodata.gd_service.pojo.OneWell;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface WellDateMapper {

    @Select("select * from well01 where id=#{id}")
    OneWell findById(@Param("id") int id);
}
