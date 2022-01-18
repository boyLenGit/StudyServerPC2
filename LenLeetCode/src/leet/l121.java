package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class l121 {
    public static int maxProfit(int[] prices) {
        // 超时。
        int result = 0;
        int cnt1 = 0;
        ArrayList<Integer> inputs = (ArrayList<Integer>) Arrays.stream(prices).boxed().collect(Collectors.toList());
        int[] copyer = prices.clone();
        Arrays.sort(copyer);
        // i1是最小值索引，i2是最大值索引
        for (int i1=0; i1<copyer.length; i1++){
            if (i1!=0) if (copyer[i1]==copyer[i1-1]) continue;
            for (int i2=copyer.length-1; i2>i1; i2--){
                int debug1 = inputs.indexOf(copyer[i1]);
                int debug2 = inputs.lastIndexOf(copyer[i2]);
                int copyer1 = copyer[i1];
                int copyer2 = copyer[i2];
                if (i2!=copyer.length-1) if (copyer[i2]==copyer[i2+1]) continue;
                if (inputs.indexOf(copyer[i1])<inputs.lastIndexOf(copyer[i2])) {
                    result = Math.max(result, copyer[i2]-copyer[i1]);
                    break;
                }
            }
            if(result!=0 & cnt1>copyer.length/2) break;
            cnt1++;
        }
        return result;
    }

    public static int maxProfit2(int[] prices) {
        // 参考了大神方法，牛批！
        // 已记录到notion中
        int min_value = prices[0];
        int result = 0;
        for (int i1=1; i1<prices.length; i1++){
            min_value = Math.min(min_value, prices[i1]);
            if (prices[i1]>min_value) result = Math.max(result, prices[i1]-min_value);
        }
        return result;
    }

    public static void main(String[] as){
        System.out.println(maxProfit(new int[]{3,2,6,5,0,3}));
    }
}
// [2,1,2,0,1]
// [3,2,6,5,0,3]