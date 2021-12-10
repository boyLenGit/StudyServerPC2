<<<<<<< HEAD
package len.dao;

import len.pojo.Obj03_MultiDao;

import java.util.List;

public interface Dao03_MultiDao {
    // 查询全部用户
    List<Obj03_MultiDao> Dao03_getUserList();

    // 根据ID查询用户
    Obj03_MultiDao Dao03_getUserById(int dao03_id);

    // 插入一个用户
    int Dao03_addUser(Obj03_MultiDao dao03_user);

    // 修改一个用户
    int Dao03_updateUser(Obj03_MultiDao dao03_update_user);

    // 删除一个用户
    int Dao03_deleteUser(int dao03_id);

    List<Obj03_MultiDao> Dao03_getUserLike(String dao03_value);
}
=======
package len.dao;

import len.pojo.Obj03_MultiDao;

import java.util.List;

public interface Dao03_MultiDao {
    // 查询全部用户
    List<Obj03_MultiDao> Dao03_getUserList();

    // 根据ID查询用户
    Obj03_MultiDao Dao03_getUserById(int dao03_id);

    // 插入一个用户
    int Dao03_addUser(Obj03_MultiDao dao03_user);

    // 修改一个用户
    int Dao03_updateUser(Obj03_MultiDao dao03_update_user);

    // 删除一个用户
    int Dao03_deleteUser(int dao03_id);

    List<Obj03_MultiDao> Dao03_getUserLike(String dao03_value);
}
>>>>>>> 1da3f48 (first commit)
