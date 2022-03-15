package leet;

import java.util.ArrayList;
import java.util.List;

public class l118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        res.add(temp);
        for (int i1=0; i1<numRows-1; i1++){
            temp = new ArrayList<>();
            for (int i2=0; i2<res.get(i1).size()+1;i2++){
                if (i2==0 | i2==res.get(i1).size()){
                    temp.add(1);continue;
                }
                temp.add( (res.get(i1).get(i2-1) + res.get(i1).get(i2)) );
            }
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] ar){
        System.out.println(generate(5));
    }
}
