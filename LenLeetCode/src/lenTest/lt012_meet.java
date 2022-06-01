package lenTest;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;

public class lt012_meet {
    public static String convert (String number, int n, int m) {
        // write code here
        BigInteger bigInteger = new BigInteger(number, n);
        return bigInteger.toString(m);
    }

    public int NumOfTriangle (int[] edges) {
        // write code here
        Arrays.sort(edges);
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i1=0; i1<edges.length; i1++){
            map.put(edges[i1], 1);
        }
        
        int res = 0;
        for (int i1=0; i1<edges.length; ++i1) {
            int temp = i1;
            for (int i2=i1+1; i2<edges.length; ++i2) {
                while (temp+1<edges.length && edges[temp+1]<edges[i1]+edges[i2]) {
                    ++temp;
                }
                res += Math.max(temp - i2, 0);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(convert("11111", 2, 16));
    }
}
