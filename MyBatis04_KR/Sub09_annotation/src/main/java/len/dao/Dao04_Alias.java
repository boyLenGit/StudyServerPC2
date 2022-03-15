<<<<<<< HEAD
package len.dao;

import len.pojo.Obj04_Alias;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface Dao04_Alias {
    // 查询全部用户
    @Select("select * from MyBatis_KR.user")
    List<Obj04_Alias> Dao04_getUserList();

    // 使用注解的方法。 方法如果存在多个参数，则需要对所有参数的前面都加上@Param("id")才可以
    @Select("select * from MyBatis_KR.user where id = #{id}")
    Obj04_Alias Dao04_getUserByID(@Param("id") int id);

    // 方法()中的类型，取决于MySQL指令中要输入的类型
    @Insert("insert into MyBatis_KR.user(id,name,pwd) values (#{id},#{name},#{pwd})")
    int Dao04_addUser(Obj04_Alias obj_user);

    @Update("update MyBatis_KR.user set name=#{name},pwd=#{pwd} where id = #{id}")
    int Dao04_updateUser(Obj04_Alias user);

    @Delete("delete from MyBatis_KR.user where id = #{id}")
    int Dao04_deleteUser(@Param("id") int id);

    // 多参数时的用法
    @Insert("insert into MyBatis_KR.user(id,name,pwd) values (#{id},#{name},#{pwd})")
    int Dao04_addUser_Param(@Param("id") int id, @Param("name") String name, @Param("pwd") String pwd);
}
=======
package len.dao;

import len.pojo.Obj04_Alias;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface Dao04_Alias {
    // 查询全部用户
    @Select("select * from MyBatis_KR.user")
    List<Obj04_Alias> Dao04_getUserList();

    // 使用注解的方法。 方法如果存在多个参数，则需要对所有参数的前面都加上@Param("id")才可以
    @Select("select * from MyBatis_KR.user where id = #{id}")
    Obj04_Alias Dao04_getUserByID(@Param("id") int id);

    // 方法()中的类型，取决于MySQL指令中要输入的类型
    @Insert("insert into MyBatis_KR.user(id,name,pwd) values (#{id},#{name},#{pwd})")
    int Dao04_addUser(Obj04_Alias obj_user);

    @Update("update MyBatis_KR.user set name=#{name},pwd=#{pwd} where id = #{id}")
    int Dao04_updateUser(Obj04_Alias user);

    @Delete("delete from MyBatis_KR.user where id = #{id}")
    int Dao04_deleteUser(@Param("id") int id);

    // 多参数时的用法
    @Insert("insert into MyBatis_KR.user(id,name,pwd) values (#{id},#{name},#{pwd})")
    int Dao04_addUser_Param(@Param("id") int id, @Param("name") String name, @Param("pwd") String pwd);
}
>>>>>>> 1da3f48 (first commit)
