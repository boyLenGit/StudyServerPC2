<<<<<<< HEAD
package dao;

import len.dao.Dao04_Alias;
import len.mybatis.S02_Start_hm;
import len.pojo.Obj04_Alias;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
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
        // ******************************** 修改部分 ********************************
        List<Obj04_Alias> list_obj_user = dao_user.Dao04_getUserList();
        for(Obj04_Alias user: list_obj_user){
            System.out.println("MyBatis测试：" + user);
        }
        // ******************************** 修改部分 ********************************
        // 关闭SQLSession
        sqlSession1.close();
    }

    @Test
    public void T04_getUserByLimit(){
        SqlSession sqlSession1 = S02_Start_hm.getSqlSession();
        Dao04_Alias dao_user = sqlSession1.getMapper(Dao04_Alias.class);
        // ******************************** 修改部分 ********************************
        HashMap<String, Integer> map_test = new HashMap<String, Integer>();
        map_test.put("startIndex1", 0);
        map_test.put("pageSize1", 2);
        List<Obj04_Alias> list_obj_user = dao_user.Dao04_getUserByLimit(map_test);
        System.out.println("MyBatis测试0：" + list_obj_user);
        for(Obj04_Alias user: list_obj_user){
            System.out.println("MyBatis测试1：" + user);
        }
        // ******************************** 修改部分 ********************************
        // 关闭SQLSession
        sqlSession1.close();
    }
}
=======
package dao;

import len.dao.Dao04_Alias;
import len.mybatis.S02_Start_hm;
import len.pojo.Obj04_Alias;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
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
        // ******************************** 修改部分 ********************************
        List<Obj04_Alias> list_obj_user = dao_user.Dao04_getUserList();
        for(Obj04_Alias user: list_obj_user){
            System.out.println("MyBatis测试：" + user);
        }
        // ******************************** 修改部分 ********************************
        // 关闭SQLSession
        sqlSession1.close();
    }

    @Test
    public void T04_getUserByLimit(){
        SqlSession sqlSession1 = S02_Start_hm.getSqlSession();
        Dao04_Alias dao_user = sqlSession1.getMapper(Dao04_Alias.class);
        // ******************************** 修改部分 ********************************
        HashMap<String, Integer> map_test = new HashMap<String, Integer>();
        map_test.put("startIndex1", 0);
        map_test.put("pageSize1", 2);
        List<Obj04_Alias> list_obj_user = dao_user.Dao04_getUserByLimit(map_test);
        System.out.println("MyBatis测试0：" + list_obj_user);
        for(Obj04_Alias user: list_obj_user){
            System.out.println("MyBatis测试1：" + user);
        }
        // ******************************** 修改部分 ********************************
        // 关闭SQLSession
        sqlSession1.close();
    }
}
>>>>>>> 1da3f48 (first commit)
