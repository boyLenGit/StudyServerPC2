package JZoffer;

import java.util.ArrayList;

public class jz042 {
    public static int maxSubArray(int[] nums) {
        if (nums.length==0) return 0;
        int sum = 0;
        int res = nums[0];
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else sum = num;
            res = Math.max(res, sum);
        }
        return sum;
    }

    public static int maxSubArray2(int[] nums) {
        if (nums==null)  return 0;
        int ans=nums[0]; // 遍历所有的情况中的最大和
        int sum=0; // 当前子数组的和情况
        // 遍历数组  如果有正数  那么最大和子数组应该是以正数开头正数结尾的
        // 对于全都是负数的情况  那么遍历获取最大的负数就可以了
        // 当正数开始  并且一直相加和>0的时候  允许你中间有部分容错（即中间存在部分负数）
        // 此时记录遍历的最大和情况  即 ans=Math.max(sum,ans);
        //如果和<=0了 那么代表容错没有了 加上后续的值无论后面的是正负哪种，都还不如不加
        // 直接以后面的值作为新的子数组开头 继续遍历
        for(int num:nums){
            //如果和大于0  则加上遍历的数字  即使num<0也没事  允许其有部分容错
            if (sum>0){
                sum+=num;
            }else{
                // 和小于0了  那么就让和等于num  就代表从该值重新开启新的连续子数组
                sum=num;
            }
            //保存获得此时最大和
            ans=Math.max(sum,ans);
        }
        return ans;
    }

    public static void main(String[] arg){
        System.out.println(maxSubArray2(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
