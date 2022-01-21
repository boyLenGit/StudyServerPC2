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

    public static void main(String[] a){
        int[] inputs = new int[]{2,3,4,1};
        selectSort(inputs);
        System.out.println(inputs);
    }
}
