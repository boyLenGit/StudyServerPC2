<<<<<<< HEAD
package len.pojo;

public class Obj04_Alias {
    private int id;
    private String name;
    private String password;

    public Obj04_Alias(){    }

    public Obj04_Alias(int id, String name, String pwd) {
        /*
        这里是用于new方法时的参数传入，如果没有这个方法，就不能用new Obj03_MultiDao(4, "12", "12313")这样的形式来创建Obj03_MultiDao对象
         */
        this.id = id;
        this.name = name;
        this.password = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return password;
    }

    public void setPwd(String pwd) {
        this.password = pwd;
    }

    @Override
    public String toString() {
        return "mybatis01_user_mysql{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + password + '\'' +
                '}';
    }
}
=======
package len.pojo;

public class Obj04_Alias {
    private int id;
    private String name;
    private String password;

    public Obj04_Alias(){    }

    public Obj04_Alias(int id, String name, String pwd) {
        /*
        这里是用于new方法时的参数传入，如果没有这个方法，就不能用new Obj03_MultiDao(4, "12", "12313")这样的形式来创建Obj03_MultiDao对象
         */
        this.id = id;
        this.name = name;
        this.password = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return password;
    }

    public void setPwd(String pwd) {
        this.password = pwd;
    }

    @Override
    public String toString() {
        return "mybatis01_user_mysql{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + password + '\'' +
                '}';
    }
}
>>>>>>> 1da3f48 (first commit)
