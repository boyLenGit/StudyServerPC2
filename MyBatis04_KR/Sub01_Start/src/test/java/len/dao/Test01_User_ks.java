<<<<<<< HEAD
package len.dao;

import len.mybatis.S01_Start;
import len.pojo.Obj01_User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.List;

public class Test01_User_ks {
    @Test
    public void test(){
        // 第一步：获得SqlSession对象
        SqlSession sqlSession1 = S01_Start.getSqlSession();
        //      方式一：通过getMapper获得
        Dao01_User dao_user = sqlSession1.getMapper(Dao01_User.class);
        List<Obj01_User> list_obj_user = dao_user.getUserList1();
        for(Obj01_User user: list_obj_user){
            System.out.println("MyBatis测试1：" + user);
        }
        //      方式二：通过selectXXX方法（已过时！）
        /*
        List<Obj01_User> list_obj_user_2 = sqlSession1.selectList("len.dao.Dao01_User.getUserList1");
        for(Obj01_User user: list_obj_user_2){
            System.out.println("MyBatis测试2：" + user);
        }
        */


        // 关闭SQLSession
        sqlSession1.close();
    }
}
=======
package len.dao;

import len.mybatis.S01_Start;
import len.pojo.Obj01_User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.List;

public class Test01_User_ks {
    @Test
    public void test(){
        // 第一步：获得SqlSession对象
        SqlSession sqlSession1 = S01_Start.getSqlSession();
        //      方式一：通过getMapper获得
        Dao01_User dao_user = sqlSession1.getMapper(Dao01_User.class);
        List<Obj01_User> list_obj_user = dao_user.getUserList1();
        for(Obj01_User user: list_obj_user){
            System.out.println("MyBatis测试1：" + user);
        }
        //      方式二：通过selectXXX方法（已过时！）
        /*
        List<Obj01_User> list_obj_user_2 = sqlSession1.selectList("len.dao.Dao01_User.getUserList1");
        for(Obj01_User user: list_obj_user_2){
            System.out.println("MyBatis测试2：" + user);
        }
        */


        // 关闭SQLSession
        sqlSession1.close();
    }
}
>>>>>>> 1da3f48 (first commit)
