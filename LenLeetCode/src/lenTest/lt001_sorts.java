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
                if (nums[i2]<nums[i1]) min_id=i2;
            }
            int temp = nums[i1];
            nums[i1] = temp;
            nums[min_id] = temp;
        }
    }

    public static void main(String[] a){
        int[] inputs = new int[]{2,3,4,1};
        len_select_sort(inputs);
        System.out.println(inputs);
    }
}
