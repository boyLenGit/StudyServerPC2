package leet;

public class l136 {
    public static int singleNumber(int[] nums) {
        int min;
        for (int i1=0; i1<nums.length; i1++){
            min = i1;
            for (int i2=i1+1; i2<nums.length; i2++){
                if (nums[min]>nums[i2]) min = i2;
            }
            int temp = nums[min];
            nums[min] = nums[i1];
            nums[i1] = temp;
        }

        int res = nums[0];
        for (int i1=1; i1<nums.length; i1++){
            if (i1+1<nums.length) {
                if (nums[i1]!=nums[i1-1] & nums[i1]!=nums[i1+1]) res = nums[i1];
            }else {
                if (nums[i1]!=nums[i1-1]) res = nums[i1];
            }
        }
        return res;
    }

    public static void main(String[] a){
        int[] inputs = new int[]{17,12,5,-6,12,4,17,-5,2,-3,2,4,5,16,-3,-4,15,15,-4,-5,-6};
        singleNumber(inputs);
    }
}


//[17,12,5,-6,12,4,17,-5,2,-3,2,4,5,16,-3,-4,15,15,-4,-5,-6]