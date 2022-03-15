package test_static;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Phone {
    public static int num_static = 5;
    public int num_ = 10;

    public static String call_static(int in1){
        return "calling_static";
    }

    String call_(int i1){
        return "calling";
    }
}

class test1{
    String teststatci(){
        Phone phone = new Phone();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        return "";
    }
}
