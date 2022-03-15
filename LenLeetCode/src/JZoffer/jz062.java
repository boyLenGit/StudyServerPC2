package JZoffer;

import java.util.ArrayList;

public class jz062 {
    public static int lastRemaining(int n, int m) {
        ArrayList<Integer> dy = new ArrayList<>();
        for (int i1=0; i1<n; i1++) dy.add(i1);
        int index = m-1;
        for (int i1=0; i1<n-1; i1++){
            while (index>=dy.size()) index -= dy.size();
            dy.remove(index);
            index = index+(m-1);
        }
        return dy.get(0);
    }

    public static void main(String[] arg){
        System.out.println(lastRemaining(10,17));
    }
}

