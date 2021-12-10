package com.hou.dao;

import com.hou.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {

    @Select("select * from MyBatis_KR.user where id =#{tid}")
    Teacher getTeacher(@Param("tid") int id);

}
