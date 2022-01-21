package lenTest;

public class lt001_sorts {
    public static void selectSort(int [] nums){
        int N=nums.length;
        for(int i=0; i<N; i++){
            int min=i;
            for(int j=i+1;j<N;j++){
                if(nums[j]<nums[min]) min=j;
            }
            int t=nums[i];
            nums[i]=nums[min];
            nums[min]=t;
        }
    }

    public static void len_select_sort(int[] nums){
        int min_id;
        for (int i1=0; i1<nums.length; i1++){
            min_id = i1;
            for (int i2=i1+1; i2<nums.length; i2++){
                if (nums[i2]<nums[min_id]) min_id=i2;
            }
            int temp = nums[i1];
            nums[i1] = nums[min_id];
            nums[min_id] = temp;
        }
    }


    public static void quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high) return;
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

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
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
    }


    public static void main(String[] a){
        int[] inputs = new int[]{5,2,4,1,3,6,0};
        quickSort(inputs, 0, inputs.length-1);
        System.out.println(inputs);
    }
}
