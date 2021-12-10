<<<<<<< HEAD
package len.dao;

import len.pojo.Obj04_Alias;

import java.util.List;
import java.util.Map;

public interface Dao04_Alias {
    // 查询全部用户
    List<Obj04_Alias> Dao04_getUserList();

    // Limit分页显示    Map<String ,Integer>中可以是String也可以是Integer
    List<Obj04_Alias> Dao04_getUserByLimit(Map<String ,Integer> map_dao);
}
=======
package len.dao;

import len.pojo.Obj04_Alias;

import java.util.List;
import java.util.Map;

public interface Dao04_Alias {
    // 查询全部用户
    List<Obj04_Alias> Dao04_getUserList();

    // Limit分页显示    Map<String ,Integer>中可以是String也可以是Integer
    List<Obj04_Alias> Dao04_getUserByLimit(Map<String ,Integer> map_dao);
}
>>>>>>> 1da3f48 (first commit)
