package com.hou.dao;

import com.hou.pojo.Student;
import com.hou.pojo.Teacher;
import com.hou.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {

    @Test
    public void test(){
        // 获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 1.执行 getmapper
        TeacherMapper userDao = sqlSession.getMapper(TeacherMapper.class);
        Teacher user = userDao.getTeacher(1);
        System.out.println(user);
    }

    @Test
    public void getStudent(){
        // 获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 1.执行 getmapper
        StudentMapper userDao = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = userDao.getStudent();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
