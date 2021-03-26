package len.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 【Mybatis的工具类】
 */

public class S01_Start {
    // 这里的目的是让getSqlSession方法获取到sqlSessionFactory1
    private static SqlSessionFactory sqlSessionFactory1;

    static {
        // 使用MyBatis获取SqlSessionFactory对象
        try {
            String resource1 = "mybatis-config.xml";
            InputStream inputStream1 = Resources.getResourceAsStream(resource1);
            sqlSessionFactory1 = new SqlSessionFactoryBuilder().build(inputStream1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // [F] 这里创建SqlSession的示例，并返回。（SqlSession都是通过SqlSessionFactory创建的）
    public static SqlSession getSqlSession(){
        return sqlSessionFactory1.openSession();
    }
}
