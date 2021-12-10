package len.mapper;

import len.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.List;

public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper {

    public List<User> selectAllUsers(){
        SqlSession sqlSession1 = getSqlSession();
        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        return userMapper1.selectAllUsers();
    }

    public User getUserById(int int_id) {
        return getSqlSession().getMapper(UserMapper.class).getUserById(int_id);
    }
}
