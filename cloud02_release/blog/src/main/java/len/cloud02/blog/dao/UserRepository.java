package len.cloud02.blog.dao;

import len.cloud02.blog.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> { // 这里的Long是主键的数据类型

    // ↓ JPA的写法，它会根据变量名自己生成数据库查表语句
    User findByUsernameAndPassword(String username, String password);

    User findByUsername(String username);
}
