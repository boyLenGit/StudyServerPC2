package len.dao;

import len.pojo.Obj_teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface Dao_teacher {

    Obj_teacher Dao_getTeacher(@Param("dao_t_id") int id);
}
