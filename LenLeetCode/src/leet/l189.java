package leet;

public class l189 {
    public static void rotate(int[] nums, int k) {
        int[] copy_nums = nums.clone();
        for (int i1=0; i1<nums.length; i1++){
            if (i1+k<nums.length)nums[i1+k] = copy_nums[i1];
            else nums[i1+k-nums.length] = copy_nums[i1];
        }
    }

    public static void main(String[] a){
        int[] inputs = new int[]{1,2,3,4,5,6,7};
        rotate(inputs, 3);
        System.out.println(inputs);
    }
}
