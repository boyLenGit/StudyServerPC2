package leet;

public class l912 {
    public static int[] sortArray(int[] nums) {
        int min;
        for (int i1=0; i1<nums.length; i1++){
            min = i1;
            for (int i2=i1+1; i2<nums.length; i2++){
                if (nums[i2]<nums[min]) min = i2;
            }
            int temp = nums[i1];
            nums[i1] = nums[min];
            nums[min] = temp;
        }
        return nums;
    }

    public static int[] sortArray2(int[] nums) {
        quickSort(nums, 0, nums.length);
        return nums;
    }

    public static void quickSort(int[] arr, int start, int end){
        int i,j,temp,t;
        if(start>end) return;
        i = start;
        j = end;
        //temp就是基准位
        temp = arr[start];

        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) j--;
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) i++;
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        arr[start] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, start, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, end);
    }

    public static void main(String[] a){
        int[] inputs = new int[]{5,1,1,2,0,0};
        System.out.println(inputs);
    }
}

