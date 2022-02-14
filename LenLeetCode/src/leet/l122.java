package leet;

public class l122 {
    public static int maxProfit(int[] prices) {
        int sum=0, sum_max=0, res = 0;
        for (int i1=1, i2=i1; i2<prices.length; i2++){
            if (sum<=0) {
                res += sum_max;
                sum_max=0;
                sum = prices[i2]-prices[i2-1];
            }else {
                sum += prices[i2]-prices[i2-1];
            }
            sum_max = Math.max(sum, sum_max);
        }
        return res;
    }

    public static void main(String[] arg){
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
