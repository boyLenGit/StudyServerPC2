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

    public static void quickSort(int[] arr,int l,int r){
        if(l<r){ //跳出递归的条件
            //partition就是划分操作，将arr划分成满足条件的两个子表
            int pivotpos = partition(arr,l,r);
            //依次对左右两个子表进行递归排序
            quickSort(arr,l,pivotpos);
            quickSort(arr,pivotpos+1,r);
        }
    }

    public static int partition(int[] arr,int l,int r){
        //以当前数组的最后一个元素作为中枢pivot，进行划分
        int pivot = arr[r];
        while (l<r){
            while (l<r && arr[l]<pivot) l++;
            arr[r] = arr[l];//将比中枢值大的移动到右端r处 由于r处为中枢或者该位置值已经被替换到l处，所以直接可以替换
            while (l<r && arr[r]>=pivot) r--;
            arr[l] = arr[r];//将比中枢值小的移动到左端l处 由于前面l处的值已经换到r处，所以该位置值也可以替换掉
        }
        //l==r时，重合，这个位置就是中枢的最终位置
        arr[l] = pivot;
        //返回存放中枢的最终位置
        return l;
    }

    public static void main(String[] a){
        int[] inputs = new int[]{5,2,4,1,3,6,0};
        quickSort(inputs, 0, inputs.length);
        System.out.println(inputs);
    }
}
