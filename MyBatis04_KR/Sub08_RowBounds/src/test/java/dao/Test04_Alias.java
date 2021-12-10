<<<<<<< HEAD
package dao;

import len.dao.Dao04_Alias;
import len.mybatis.S02_Start_hm;
import len.pojo.Obj04_Alias;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * [黑马版MyBatis示例代码]
 *      ·与狂人java的区别：Obj02多了个toString()方法，从而在输出内容上有所区别
 */

public class Test04_Alias {

    @Test // ↓ 获取全部user内容
    public void T04_getUserList(){
        // 获得SqlSession对象
        SqlSession sqlSession1 = S02_Start_hm.getSqlSession();
        Dao04_Alias dao_user = sqlSession1.getMapper(Dao04_Alias.class);
        List<Obj04_Alias> list_obj_user = dao_user.Dao04_getUserList();
        for(Obj04_Alias user: list_obj_user){
            System.out.println("MyBatis测试：" + user);
        }
        // 关闭SQLSession
        sqlSession1.close();
    }

    @Test
    public void T04_getUserByRowBounds(){
        SqlSession sqlSession1 = S02_Start_hm.getSqlSession();
        // RowBounds实现MySQL分页
        RowBounds rowBounds1 = new RowBounds(1,2);
        List<Obj04_Alias> userList = sqlSession1.selectList("len.dao.Dao04_Alias.getUserByRowBounds", null, rowBounds1);

        for(Obj04_Alias user: userList){
            System.out.println("MyBatis测试：" + user);
        }
    }

}
=======
package dao;

import len.dao.Dao04_Alias;
import len.mybatis.S02_Start_hm;
import len.pojo.Obj04_Alias;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * [黑马版MyBatis示例代码]
 *      ·与狂人java的区别：Obj02多了个toString()方法，从而在输出内容上有所区别
 */

public class Test04_Alias {

    @Test // ↓ 获取全部user内容
    public void T04_getUserList(){
        // 获得SqlSession对象
        SqlSession sqlSession1 = S02_Start_hm.getSqlSession();
        Dao04_Alias dao_user = sqlSession1.getMapper(Dao04_Alias.class);
        List<Obj04_Alias> list_obj_user = dao_user.Dao04_getUserList();
        for(Obj04_Alias user: list_obj_user){
            System.out.println("MyBatis测试：" + user);
        }
        // 关闭SQLSession
        sqlSession1.close();
    }

    @Test
    public void T04_getUserByRowBounds(){
        SqlSession sqlSession1 = S02_Start_hm.getSqlSession();
        // RowBounds实现MySQL分页
        RowBounds rowBounds1 = new RowBounds(1,2);
        List<Obj04_Alias> userList = sqlSession1.selectList("len.dao.Dao04_Alias.getUserByRowBounds", null, rowBounds1);

        for(Obj04_Alias user: userList){
            System.out.println("MyBatis测试：" + user);
        }
    }

}
>>>>>>> 1da3f48 (first commit)
