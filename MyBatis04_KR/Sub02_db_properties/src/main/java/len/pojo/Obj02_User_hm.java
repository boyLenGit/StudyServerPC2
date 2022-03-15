<<<<<<< HEAD
package len.pojo;

import java.io.Serializable;

public class Obj02_User_hm implements Serializable { // mybatis01_user_mysql继承Serializable的接口
    private Integer id;
    private String name;
    private String pwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return name;
    }

    public void setUsername(String username) {
        this.name = username;
    }

    public String getAddress() {
        return pwd;
    }

    public void setAddress(String address) {
        this.pwd = address;
    }

    @Override
    public String toString() {
        return "mybatis01_user_mysql{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
=======
package len.pojo;

import java.io.Serializable;

public class Obj02_User_hm implements Serializable { // mybatis01_user_mysql继承Serializable的接口
    private Integer id;
    private String name;
    private String pwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return name;
    }

    public void setUsername(String username) {
        this.name = username;
    }

    public String getAddress() {
        return pwd;
    }

    public void setAddress(String address) {
        this.pwd = address;
    }

    @Override
    public String toString() {
        return "mybatis01_user_mysql{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
>>>>>>> 1da3f48 (first commit)
