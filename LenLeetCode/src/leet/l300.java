package leet;

import java.util.ArrayList;

public class l300 {
    public static int lengthOfLIS(int[] nums) {
        int cnt=0;
        int res=0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i1=0; i1<nums.length; i1++){
            for (int i2=0; i2<arrayList.size(); i2++){
                if (nums[i1]>nums[i2]){
                    arrayList.set(i2, arrayList.get(i2)+1);
                    res = Math.max(arrayList.get(i2), res);
                }
            }
            arrayList.add(1);
        }
        return res;
    }

    public static void main(String[] arg){
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
