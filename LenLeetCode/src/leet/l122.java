package leet;

public class l122 {
    public static int maxProfit(int[] prices) {
        int sum=0, sum_max=0, res = 0;
        for (int i1=1; i1<prices.length; i1++){
            if (prices[i1]-prices[i1-1]>=0){
                sum += prices[i1]-prices[i1-1];
            }else {
                sum = 0;
                res += sum_max;
                sum_max = 0;
            }
            sum_max = Math.max(sum_max, sum);
        }
        res += sum_max;
        return res;
    }

    
    public static void main(String[] arg){
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
    }
}
