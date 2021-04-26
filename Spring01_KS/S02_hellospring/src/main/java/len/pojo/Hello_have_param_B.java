package len.pojo;

public class Hello_have_param_B {
    private String str;

    public Hello_have_param_B(String str){
        System.out.println("有参构造B"+str);
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
