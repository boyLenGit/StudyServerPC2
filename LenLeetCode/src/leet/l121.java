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
        int single_lock = 0;
        // i1是最小值索引，i2是最大值索引
        for (int i1=0, i2=copyer.length-1; i1<i2;){
            int debug1 = inputs.indexOf(copyer[i1]);
            int debug2 = inputs.indexOf(copyer[i2]);
            if (inputs.indexOf(copyer[i1])<inputs.indexOf(copyer[i2])){
                result = Math.max(result, (copyer[i2]-copyer[i1]));
            }else {
                if (single_lock==0){
                    i1++;
                    single_lock = 1;
                }else {
                    i2--;
                    single_lock = 0;
                }
            }
        }
        return result;
    }

    public static void main(String[] as){
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
