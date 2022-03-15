<<<<<<< HEAD
package len.dao;

import len.pojo.Obj03_MultiDao;
import len.pojo.Obj04_Alias;

import java.util.List;

public interface Dao04_Alias {
    // 查询全部用户
    List<Obj04_Alias> Dao04_getUserList();

    // 根据ID查询用户
    Obj04_Alias Dao04_getUserById(int dao04_id);

    // 插入一个用户
    int Dao04_addUser(Obj04_Alias dao04_user);

    // 修改一个用户
    int Dao04_updateUser(Obj04_Alias dao04_update_user);

    // 删除一个用户
    int Dao04_deleteUser(int dao04_id);

    List<Obj04_Alias> Dao04_getUserLike(String dao04_value);
}
=======
package len.dao;

import len.pojo.Obj03_MultiDao;
import len.pojo.Obj04_Alias;

import java.util.List;

public interface Dao04_Alias {
    // 查询全部用户
    List<Obj04_Alias> Dao04_getUserList();

    // 根据ID查询用户
    Obj04_Alias Dao04_getUserById(int dao04_id);

    // 插入一个用户
    int Dao04_addUser(Obj04_Alias dao04_user);

    // 修改一个用户
    int Dao04_updateUser(Obj04_Alias dao04_update_user);

    // 删除一个用户
    int Dao04_deleteUser(int dao04_id);

    List<Obj04_Alias> Dao04_getUserLike(String dao04_value);
}
>>>>>>> 1da3f48 (first commit)
