<<<<<<< HEAD
package len.dao;

import len.mybatis.S02_Start_hm;
import len.pojo.Obj04_Alias;
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

    @Test // ↓ 通过id值获取user中指定内容
    public void T04_getUserByID(){
        SqlSession sqlSession1 = S02_Start_hm.getSqlSession();
        Dao04_Alias user_mapper = sqlSession1.getMapper(Dao04_Alias.class);
        Obj04_Alias user_object = user_mapper.Dao04_getUserById(1);
        System.out.println("获取用户测试" + user_object);
        sqlSession1.close();
    }

    @Test // ↓ 添加一行数据
    public void T04_addUser(){
        SqlSession sqlSession1 = S02_Start_hm.getSqlSession();
        Dao04_Alias user_mapper = sqlSession1.getMapper(Dao04_Alias.class);
        int result = user_mapper.Dao04_addUser(new Obj04_Alias(6, "答案", "9999"));
        if(result>0){
            System.out.println("插入新用户成功，成功代码：" + result);
        }
        sqlSession1.commit();// 增删改操作必须要commit提交事务才有效果！
        sqlSession1.close();
    }

    @Test // ↓ 更新一行数据
    public void T04_updateUser(){
        SqlSession sqlSession1 = S02_Start_hm.getSqlSession();
        Dao04_Alias user_mapper = sqlSession1.getMapper(Dao04_Alias.class);
        int result2 = user_mapper.Dao04_updateUser(new Obj04_Alias(2, "答案", "9999"));
        if(result2>0){
            System.out.println("更新用户成功，成功代码：" + result2);
        }
        sqlSession1.commit();// 增删改操作必须要commit提交事务才有效果！
        sqlSession1.close();
    }

    @Test // ↓ 删除一行数据
    public void T04_deleteUser(){
        SqlSession sqlSession1 = S02_Start_hm.getSqlSession();
        Dao04_Alias user_mapper = sqlSession1.getMapper(Dao04_Alias.class);
        int result2 = user_mapper.Dao04_deleteUser(1);
        if(result2>0){
            System.out.println("删除用户成功，成功代码：" + result2);
        }
        sqlSession1.commit();// 增删改操作必须要commit提交事务才有效果！
        sqlSession1.close();
    }

    @Test // ↓ 模糊查询
    public void T04_getUserLike(){
        SqlSession sqlSession1 = S02_Start_hm.getSqlSession();
        Dao04_Alias user_mapper = sqlSession1.getMapper(Dao04_Alias.class);
        List<Obj04_Alias> list_obj_user = user_mapper.Dao04_getUserLike("%老%");
        for(Obj04_Alias user: list_obj_user){
            System.out.println("模糊查询：" + user);
        }
        sqlSession1.close();
    }
}
=======
package len.dao;

import len.mybatis.S02_Start_hm;
import len.pojo.Obj04_Alias;
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

    @Test // ↓ 通过id值获取user中指定内容
    public void T04_getUserByID(){
        SqlSession sqlSession1 = S02_Start_hm.getSqlSession();
        Dao04_Alias user_mapper = sqlSession1.getMapper(Dao04_Alias.class);
        Obj04_Alias user_object = user_mapper.Dao04_getUserById(1);
        System.out.println("获取用户测试" + user_object);
        sqlSession1.close();
    }

    @Test // ↓ 添加一行数据
    public void T04_addUser(){
        SqlSession sqlSession1 = S02_Start_hm.getSqlSession();
        Dao04_Alias user_mapper = sqlSession1.getMapper(Dao04_Alias.class);
        int result = user_mapper.Dao04_addUser(new Obj04_Alias(6, "答案", "9999"));
        if(result>0){
            System.out.println("插入新用户成功，成功代码：" + result);
        }
        sqlSession1.commit();// 增删改操作必须要commit提交事务才有效果！
        sqlSession1.close();
    }

    @Test // ↓ 更新一行数据
    public void T04_updateUser(){
        SqlSession sqlSession1 = S02_Start_hm.getSqlSession();
        Dao04_Alias user_mapper = sqlSession1.getMapper(Dao04_Alias.class);
        int result2 = user_mapper.Dao04_updateUser(new Obj04_Alias(2, "答案", "9999"));
        if(result2>0){
            System.out.println("更新用户成功，成功代码：" + result2);
        }
        sqlSession1.commit();// 增删改操作必须要commit提交事务才有效果！
        sqlSession1.close();
    }

    @Test // ↓ 删除一行数据
    public void T04_deleteUser(){
        SqlSession sqlSession1 = S02_Start_hm.getSqlSession();
        Dao04_Alias user_mapper = sqlSession1.getMapper(Dao04_Alias.class);
        int result2 = user_mapper.Dao04_deleteUser(1);
        if(result2>0){
            System.out.println("删除用户成功，成功代码：" + result2);
        }
        sqlSession1.commit();// 增删改操作必须要commit提交事务才有效果！
        sqlSession1.close();
    }

    @Test // ↓ 模糊查询
    public void T04_getUserLike(){
        SqlSession sqlSession1 = S02_Start_hm.getSqlSession();
        Dao04_Alias user_mapper = sqlSession1.getMapper(Dao04_Alias.class);
        List<Obj04_Alias> list_obj_user = user_mapper.Dao04_getUserLike("%老%");
        for(Obj04_Alias user: list_obj_user){
            System.out.println("模糊查询：" + user);
        }
        sqlSession1.close();
    }
}
>>>>>>> 1da3f48 (first commit)
