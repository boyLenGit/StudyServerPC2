package mo;

public class calculate {
    public static void main(String[] arg){
        System.out.println("hello");
        System.out.println(add(1,2));
        People mbl = new People();
        mbl.eat(10);
        mbl.baba(1);
        mbl.eat(15);
        People.meet("9989");
    }

    // public  默认 private
    // static是Class的工具, 不加static只有对象可以用
    public static int add(int a, int b){
        int num2 = a+b;
        // 数据类型 名字1 = new 数据类型;
        // 数据类型 名字2 = 名字1;
        // 数字:int=Integer double long
        // 字符串:String StringBuilder
        // 列表:List(抽象) ArrayList
        return a+b;
    }
}

class People{
    private int weight = 50;

    void eat(int food){
        weight = weight + food;
    }

    void baba(int shit){
        weight = weight - shit;
    }

    static String meet(String content){
        String note = "会议内容" + content;
        return note;
    }
}
