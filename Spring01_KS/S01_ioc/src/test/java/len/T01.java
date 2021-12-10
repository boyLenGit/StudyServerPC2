<<<<<<< HEAD
package len;

import len.dao.UserDaoMySQLImpl;
import len.service.UserService;
import len.service.UserServiceImpl;

public class T01 {
    public static void main(String[] args){
        // 用户实际调用的是业务层，dao层他们不需要接触。但真正逻辑在dao层，service层只是中间商的角色
        UserService userService1 = new UserServiceImpl();

        userService1.setUserDao(new UserDaoMySQLImpl());
        userService1.getUser();
    }
}
=======
package len;

import len.dao.UserDaoMySQLImpl;
import len.service.UserService;
import len.service.UserServiceImpl;

public class T01 {
    public static void main(String[] args){
        // 用户实际调用的是业务层，dao层他们不需要接触。但真正逻辑在dao层，service层只是中间商的角色
        UserService userService1 = new UserServiceImpl();

        userService1.setUserDao(new UserDaoMySQLImpl());
        userService1.getUser();
    }
}
>>>>>>> 1da3f48 (first commit)
