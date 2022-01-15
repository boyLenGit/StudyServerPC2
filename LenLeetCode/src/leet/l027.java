package leet;

import java.util.Arrays;

public class l027 {
    public static int removeElement(int[] nums, int val) {
        int[] ints = nums.clone();
        int cnt = 0;
        for (int i1=0; i1<nums.length; i1++){
            if (nums[i1]==val) continue;
            nums[cnt] = ints[i1];
            cnt++;
        }
        nums = Arrays.copyOf(nums, cnt);
        return cnt;
    }
}
