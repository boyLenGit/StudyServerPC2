package len.dao;

import len.pojo.Obj_teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface Dao_teacher {

    @Select("select * from MyBatis_KR.teacher where id = #{tid}")
    Obj_teacher getTeacher(@Param("tid") int id);
}
