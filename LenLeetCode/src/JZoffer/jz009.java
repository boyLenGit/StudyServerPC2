package JZoffer;

import java.util.LinkedList;
import java.util.List;

public class jz009 {
    public static void main(String[] args) {
        CQueue obj = new CQueue();
        obj.appendTail(3);
        int param_2 = obj.deleteHead();
        int param_3 = obj.deleteHead();
    }

}

class CQueue {
    List<Integer> res;
    public CQueue() {
        res=new LinkedList<>();
    }

    public void appendTail(int value) {
        res.add(value);
    }

    public int deleteHead() {
        if (res.size()>0){
            Integer tem =res.get(0);
            res.remove(0);
            return tem;
        }else {return -1;}
    }
}
