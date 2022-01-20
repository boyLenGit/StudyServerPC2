package leet;

import java.util.Arrays;

public class l088 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int cnt = 0;
        for (int i1=m-1; i1<m+n; i1++, cnt++){
            nums1[i1] = nums2[cnt];
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] a){
        merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    }
}
