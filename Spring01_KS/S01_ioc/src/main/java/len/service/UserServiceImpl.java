<<<<<<< HEAD
package len.service;

import len.dao.UserDao;
import len.dao.UserDaoImpl;

public class UserServiceImpl implements UserService{


    private UserDao userDao;
    // 利用set进行动态实现值的输入
    public void setUserDao(UserDao userDao1){
        this.userDao = userDao1;
    }

    public void getUser() {
        userDao.getUser();
    }
}
=======
package len.service;

import len.dao.UserDao;
import len.dao.UserDaoImpl;

public class UserServiceImpl implements UserService{


    private UserDao userDao;
    // 利用set进行动态实现值的输入
    public void setUserDao(UserDao userDao1){
        this.userDao = userDao1;
    }

    public void getUser() {
        userDao.getUser();
    }
}
>>>>>>> 1da3f48 (first commit)
