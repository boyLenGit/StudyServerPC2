package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class l121 {
    public static int maxProfit(int[] prices) {
        int result = 0;
        ArrayList<Integer> inputs = (ArrayList<Integer>) Arrays.stream(prices).boxed().collect(Collectors.toList());
        int[] copyer = prices.clone();
        Arrays.sort(copyer);
        // i1是最小值索引，i2是最大值索引
        for (int i1=0; i1<copyer.length; i1++){
            for (int i2=copyer.length-1; i2>i1; i2--){
                int debug1 = inputs.indexOf(copyer[i1]);
                int debug2 = inputs.indexOf(copyer[i2]);
                if (inputs.indexOf(copyer[i1])<inputs.indexOf(copyer[i2])) return copyer[i2]-copyer[i1];
            }
        }
        return result;
    }

    public static void main(String[] as){
        System.out.println(maxProfit(new int[]{2,1,2,0,1}));
    }
}
// [2,1,2,0,1]