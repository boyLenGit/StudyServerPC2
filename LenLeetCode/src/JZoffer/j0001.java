package JZoffer;

import java.util.ArrayList;
import java.util.LinkedList;

public class j0001 {
    private ArrayList<Integer> store = new ArrayList<>();
    int temp;
    public j0001() {

    }

    public void appendTail(int value) {
        store.add(value);
    }

    public int deleteHead() {
        if (store.size()==0) return -1;
        temp = store.get(0);
        store.remove(0);
        return temp;
    }

    public static void main(String[] arg){
        j0001 obj = new j0001();
        obj.appendTail(43);
        int param_2 = obj.deleteHead();
    }
}
