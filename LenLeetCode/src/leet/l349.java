package leet;

import java.util.Arrays;
import java.util.LinkedList;

public class l349 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length>=nums2.length) return help(nums1, nums2);
        else return help(nums2, nums1);
    }

    public static int[] help(int[] big, int[] small){
        LinkedList<Integer> array = new LinkedList<>();
        Arrays.sort(small);
        int search_res;
        for (int i1=0; i1<small.length; i1++){
            if (i1!=0 && small[i1]!=small[i1-1]){
                search_res = lenSearch(big, small[i1]);
                if (search_res!=-1) array.add(small[i1]);
            }
        }
        int[] res = new int[array.size()];
        for (int i1=0; i1<array.size(); i1++){
            res[i1] = array.get(i1);
        }
        return res;
    }

    public static int lenSearch(int[] inputs, int target){
        int low=0, high=inputs.length-1, mid;
        while (low<=high){
            mid = (high-low)/2 + low;
            if (inputs[mid]==target) return mid;
            else if (inputs[mid]>target) high = mid - 1;
            else if (inputs[mid]<target) low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] arg){
        System.out.println(Arrays.toString(intersection(new int[]{1,2,2,1}, new int[]{2,2})));
    }
}
