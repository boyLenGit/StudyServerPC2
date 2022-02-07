package leet;

public class l349 {
    public int[] intersection(int[] nums1, int[] nums2) {

        return new int[]{};
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
        System.out.println(lenSearch(new int[]{1,2,2,1}, 5));
    }
}
