package mo;

import java.math.BigInteger;
import java.util.*;

public class l2 {
    public static void main(String[] arg){
        // 对象 名字1 = new 对象;
                // 例如: 数据类型 名字1 = new 数据类型;
        print("马博仑");

        // 基本数据类型
        /*
            基本数据类型->类
                int Integer
                char Character
                long Long
                double Double
                float Float
                boolean Boolean
                无 String  --> String不是基本数据类型,是一个类

         */
        boolean boolean1 = true;  //false
        int int1 = 10;
        print(String.valueOf(Integer.MAX_VALUE));  // int最大值
        print(String.valueOf(Long.MAX_VALUE));
        double double1 = 5.1;
        long long1 = 10;
        char char1 = 'c';
        char char2 = ' ';
        String string1 = "abc";

        int[] ints = new int[5];  // 5是长度
        int[] ints2 = {1,2,3,4,5};
        Arrays.sort(ints2);
        print(Arrays.toString(ints2));
        char[] chars = new char[5];
        char[][] charss1 = new char[5][];
        char[][] charss2 = new char[5][10];

        String[] strings = new String[5];
        calculate[] calculates = new calculate[5];
        // 操作基本数据类型
        print(String.valueOf( ints2[0] ));
        for (int i1=0; i1<chars.length; i1++){
            print(String.valueOf(chars[i1]));
        }
        for (char item1: chars){
            print(String.valueOf(item1));
        }

        // 列表 数组 字典
        /*
        大类:
            `List: ArrayList:数组  LinkedList:链表
            `Map: HashMap:哈希Map
            `Set: HashSet:哈希Set
        定义:
            大类 名字 = new 子类:
            子类 名字 = new 子类;
                    比如: 学生 研究生 本科生
                        学生 薛焕昇 = new 本科生();
                            ↑ 薛焕昇的方法都是'学生'的方法,但是薛焕昇的底层实现,是研究生
                        研究生 薛焕昇 = new 研究生();
         */
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        list1.add(10);
        list1.get(0);
        for (int i1=0; i1<list1.size(); i1++){
            print(String.valueOf(list1.get(i1)));
        }
        for (Integer item1 : list1) {
            print(String.valueOf(item1));
        }
        List<  Integer  > list_1v = new ArrayList<>();
        list_1v.add(10);
        List<  List<Integer>  > list_2v = new ArrayList<>();
        list_2v.add(  list_1v  );
        Map<Integer, Character> map1 = new HashMap<>();

    }

    // 定义一个方法的模板: 可不可见符号 静不静态符号 返回数据类型 方法名字(输入数据的类型1 数据名1, 数据数据的类型2 数据名2){ 代码 }
    public static int hgnbjvhg(int a, int b, int c){
        // return就相当于matlab中的[]=function(xxx)中的[]
        return a+b*c/a;
    }

    public static void print(String str){
        System.out.println(str);
    }
}
