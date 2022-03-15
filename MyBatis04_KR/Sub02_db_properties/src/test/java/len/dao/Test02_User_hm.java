<<<<<<< HEAD
package len.dao;

import len.mybatis.S01_Start;
import len.mybatis.S02_Start_hm;
import len.pojo.Obj02_User_hm;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * [黑马版MyBatis示例代码]
 *      ·与狂人java的区别：Obj02多了个toString()方法，从而在输出内容上有所区别
 */

public class Test02_User_hm {
    @Test
    public void test(){
        // 第一步：获得SqlSession对象
        SqlSession sqlSession1 = S02_Start_hm.getSqlSession();
        //      方式一：通过getMapper获得
        Dao02_User_hm dao_user = sqlSession1.getMapper(Dao02_User_hm.class);
        List<Obj02_User_hm> list_obj_user = dao_user.getUserList2_hm();
        for(Obj02_User_hm user: list_obj_user){
            System.out.println("MyBatis测试：" + user);
        }

        // 关闭SQLSession
        sqlSession1.close();
    }
}
=======
package len.dao;

import len.mybatis.S01_Start;
import len.mybatis.S02_Start_hm;
import len.pojo.Obj02_User_hm;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * [黑马版MyBatis示例代码]
 *      ·与狂人java的区别：Obj02多了个toString()方法，从而在输出内容上有所区别
 */

public class Test02_User_hm {
    @Test
    public void test(){
        // 第一步：获得SqlSession对象
        SqlSession sqlSession1 = S02_Start_hm.getSqlSession();
        //      方式一：通过getMapper获得
        Dao02_User_hm dao_user = sqlSession1.getMapper(Dao02_User_hm.class);
        List<Obj02_User_hm> list_obj_user = dao_user.getUserList2_hm();
        for(Obj02_User_hm user: list_obj_user){
            System.out.println("MyBatis测试：" + user);
        }

        // 关闭SQLSession
        sqlSession1.close();
    }
}
>>>>>>> 1da3f48 (first commit)
