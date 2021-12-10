<<<<<<< HEAD
package len.pojo;

public class Obj03_MultiDao {
    private int id;
    private String name;
    private String pwd;

    public Obj03_MultiDao(){    }

    public Obj03_MultiDao(int id, String name, String pwd) {
        /*
        这里是用于new方法时的参数传入，如果没有这个方法，就不能用new Obj03_MultiDao(4, "12", "12313")这样的形式来创建Obj03_MultiDao对象
         */
        this.id = id;
        this.name = name;
        this.pwd = pwd;
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
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
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

public class Obj03_MultiDao {
    private int id;
    private String name;
    private String pwd;

    public Obj03_MultiDao(){    }

    public Obj03_MultiDao(int id, String name, String pwd) {
        /*
        这里是用于new方法时的参数传入，如果没有这个方法，就不能用new Obj03_MultiDao(4, "12", "12313")这样的形式来创建Obj03_MultiDao对象
         */
        this.id = id;
        this.name = name;
        this.pwd = pwd;
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
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
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
