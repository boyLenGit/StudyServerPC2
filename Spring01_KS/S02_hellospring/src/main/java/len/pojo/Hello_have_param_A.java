package len.pojo;

public class Hello_have_param_A {
    private String str;

    public Hello_have_param_A(String str){
        System.out.println("有参构造A"+str);
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "Hello{" + "str='" + str + '\'' + '}';
    }
}
