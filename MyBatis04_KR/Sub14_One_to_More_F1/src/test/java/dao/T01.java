<<<<<<< HEAD
package dao;

import len.dao.Dao_student;
import len.dao.Dao_teacher;
import len.mybatis.S02_Start_hm;
import len.pojo.Obj_student;
import len.pojo.Obj_teacher;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * [黑马版MyBatis示例代码]
 *      ·与狂人java的区别：Obj02多了个toString()方法，从而在输出内容上有所区别
 */

public class T01 {

    @Test
    public void T01_getUserByID(){
        // 获得SqlSession对象
        SqlSession sqlSession1 = S02_Start_hm.getSqlSession();
        Dao_teacher dao_teacher = sqlSession1.getMapper(Dao_teacher.class);

        Obj_teacher obj_teacher = dao_teacher.Dao_getTeacher(1);
        System.out.println(obj_teacher);
        // 关闭SQLSession
        sqlSession1.close();
    }


    @Test
    public void T01_Teacher_get_Student(){
        // 获得SqlSession对象
        SqlSession sqlSession1 = S02_Start_hm.getSqlSession();
        Dao_teacher dao_teacher = sqlSession1.getMapper(Dao_teacher.class);

        Obj_teacher obj_teacher = dao_teacher.Dao_getTeacher(1);
        List<Obj_student> studentList = obj_teacher.getObj_t_student();
        for(Obj_student student: studentList){
            System.out.println(student);
        }
        // 关闭SQLSession
        sqlSession1.close();
    }
}
=======
package dao;

import len.dao.Dao_student;
import len.dao.Dao_teacher;
import len.mybatis.S02_Start_hm;
import len.pojo.Obj_student;
import len.pojo.Obj_teacher;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * [黑马版MyBatis示例代码]
 *      ·与狂人java的区别：Obj02多了个toString()方法，从而在输出内容上有所区别
 */

public class T01 {

    @Test
    public void T01_getUserByID(){
        // 获得SqlSession对象
        SqlSession sqlSession1 = S02_Start_hm.getSqlSession();
        Dao_teacher dao_teacher = sqlSession1.getMapper(Dao_teacher.class);

        Obj_teacher obj_teacher = dao_teacher.Dao_getTeacher(1);
        System.out.println(obj_teacher);
        // 关闭SQLSession
        sqlSession1.close();
    }


    @Test
    public void T01_Teacher_get_Student(){
        // 获得SqlSession对象
        SqlSession sqlSession1 = S02_Start_hm.getSqlSession();
        Dao_teacher dao_teacher = sqlSession1.getMapper(Dao_teacher.class);

        Obj_teacher obj_teacher = dao_teacher.Dao_getTeacher(1);
        List<Obj_student> studentList = obj_teacher.getObj_t_student();
        for(Obj_student student: studentList){
            System.out.println(student);
        }
        // 关闭SQLSession
        sqlSession1.close();
    }
}
>>>>>>> 1da3f48 (first commit)
