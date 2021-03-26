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

public class Test04_Alias {

    @Test // ↓ 获取全部user内容
    public void T04_getUserList(){
        // 获得SqlSession对象
        SqlSession sqlSession1 = S02_Start_hm.getSqlSession();
        Dao04_Alias dao_mapper = sqlSession1.getMapper(Dao04_Alias.class);

        Obj04_Alias list_obj_user = dao_mapper.Dao04_getUserByID(1);
        System.out.println(list_obj_user);
        // 关闭SQLSession
        sqlSession1.close();
    }
}
