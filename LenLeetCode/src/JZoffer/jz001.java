package JZoffer;

import java.util.ArrayList;

public class jz001 {
    private ArrayList<Integer> store = new ArrayList<>();
    int temp;
    public jz001() {

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
        jz001 obj = new jz001();
        obj.appendTail(43);
        int param_2 = obj.deleteHead();
    }
}
