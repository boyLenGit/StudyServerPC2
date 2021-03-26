package len.dao;

import len.pojo.Obj04_Alias;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Dao04_Alias {
    // 查询全部用户
    @Select("select * from MyBatis_KR.user")
    List<Obj04_Alias> Dao04_getUserList();

    // 使用注解的方法。 方法如果存在多个参数，则需要对所有参数的前面都加上@Param("id")才可以
    @Select("select * from MyBatis_KR.user where id = #{id}")
    Obj04_Alias Dao04_getUserByID(@Param("id") int id);
}
