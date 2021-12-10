<<<<<<< HEAD
package dao;

import len.dao.Dao04_Alias;
import len.mybatis.S02_Start_hm;
import len.pojo.Obj04_Alias;
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
        Dao04_Alias dao_mapper = sqlSession1.getMapper(Dao04_Alias.class);

        Obj04_Alias obj_user = dao_mapper.Dao04_getUserByID(5);
        System.out.println(obj_user);
        // 关闭SQLSession
        sqlSession1.close();
    }

    // 如果报错，则因为要添加的项目已存在
    @Test
    public void T01_addUser(){
        // 获得SqlSession对象      --- 固定写法 ---
        SqlSession sqlSession1 = S02_Start_hm.getSqlSession();
        Dao04_Alias dao_mapper = sqlSession1.getMapper(Dao04_Alias.class);

        dao_mapper.Dao04_addUser(new Obj04_Alias(12, "尹航", "555666"));
        // 关闭SQLSession
        sqlSession1.close();
    }

    @Test
    public void T01_updateUser(){
        // 获得SqlSession对象      --- 固定写法 ---
        SqlSession sqlSession1 = S02_Start_hm.getSqlSession();
        Dao04_Alias dao_mapper = sqlSession1.getMapper(Dao04_Alias.class);

        dao_mapper.Dao04_updateUser(new Obj04_Alias(1, "尹航", "111666"));
        // 关闭SQLSession
        sqlSession1.close();
    }

    // [删除MySQL数据] ！ 如果报错，则因为要删除的项目不存在
    @Test
    public void T01_deleteUser(){
        // 获得SqlSession对象      --- 固定写法 ---
        SqlSession sqlSession1 = S02_Start_hm.getSqlSession();
        Dao04_Alias dao_mapper = sqlSession1.getMapper(Dao04_Alias.class);

        dao_mapper.Dao04_deleteUser(1);
        // 关闭SQLSession
        sqlSession1.close();
    }

    // [删除MySQL数据] ！ 如果报错，则因为要删除的项目不存在
    @Test
    public void T01_addUser_Param(){
        // 获得SqlSession对象      --- 固定写法 ---
        SqlSession sqlSession1 = S02_Start_hm.getSqlSession();
        Dao04_Alias dao_mapper = sqlSession1.getMapper(Dao04_Alias.class);

        dao_mapper.Dao04_addUser_Param(13, "皮卡", "989898");
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
        Dao04_Alias dao_mapper = sqlSession1.getMapper(Dao04_Alias.class);

        Obj04_Alias obj_user = dao_mapper.Dao04_getUserByID(5);
        System.out.println(obj_user);
        // 关闭SQLSession
        sqlSession1.close();
    }

    // 如果报错，则因为要添加的项目已存在
    @Test
    public void T01_addUser(){
        // 获得SqlSession对象      --- 固定写法 ---
        SqlSession sqlSession1 = S02_Start_hm.getSqlSession();
        Dao04_Alias dao_mapper = sqlSession1.getMapper(Dao04_Alias.class);

        dao_mapper.Dao04_addUser(new Obj04_Alias(12, "尹航", "555666"));
        // 关闭SQLSession
        sqlSession1.close();
    }

    @Test
    public void T01_updateUser(){
        // 获得SqlSession对象      --- 固定写法 ---
        SqlSession sqlSession1 = S02_Start_hm.getSqlSession();
        Dao04_Alias dao_mapper = sqlSession1.getMapper(Dao04_Alias.class);

        dao_mapper.Dao04_updateUser(new Obj04_Alias(1, "尹航", "111666"));
        // 关闭SQLSession
        sqlSession1.close();
    }

    // [删除MySQL数据] ！ 如果报错，则因为要删除的项目不存在
    @Test
    public void T01_deleteUser(){
        // 获得SqlSession对象      --- 固定写法 ---
        SqlSession sqlSession1 = S02_Start_hm.getSqlSession();
        Dao04_Alias dao_mapper = sqlSession1.getMapper(Dao04_Alias.class);

        dao_mapper.Dao04_deleteUser(1);
        // 关闭SQLSession
        sqlSession1.close();
    }

    // [删除MySQL数据] ！ 如果报错，则因为要删除的项目不存在
    @Test
    public void T01_addUser_Param(){
        // 获得SqlSession对象      --- 固定写法 ---
        SqlSession sqlSession1 = S02_Start_hm.getSqlSession();
        Dao04_Alias dao_mapper = sqlSession1.getMapper(Dao04_Alias.class);

        dao_mapper.Dao04_addUser_Param(13, "皮卡", "989898");
        // 关闭SQLSession
        sqlSession1.close();
    }
}
>>>>>>> 1da3f48 (first commit)
