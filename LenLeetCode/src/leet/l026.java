package leet;

import java.util.Arrays;

public class l026 {
    public static int removeDuplicates(int[] nums) {
        int[] ints_in = Arrays.copyOf(nums, nums.length);
        int cnt=0;
        for (int i1=0; i1<ints_in.length; i1++){
            if (i1!=0) if (ints_in[i1]==ints_in[i1-1])continue;
            nums[cnt] = ints_in[i1];
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args){
        int result = removeDuplicates(new int[]{});
    }
}
