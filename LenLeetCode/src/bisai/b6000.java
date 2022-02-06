package bisai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class b6000 {
    public static int[] sortEvenOdd(int[] nums) {
        int len_odd=0;
        for (int item: nums){
            if (item%2!=0) len_odd++;
        }
        int[] array_odd = new int[len_odd];
        int[] array_eve = new int[nums.length-len_odd];
        int cnt_odd=0, cnt_eve=0;
        for (int item: nums){
            if (item%2==0) {
                array_eve[cnt_eve] = item;
                cnt_eve++;
            }else {
                array_eve[cnt_odd] = item;
                cnt_odd++;
            }
        }
        Arrays.sort(array_eve);
        Arrays.sort(array_odd);
        cnt_eve=0;
        for (int i1=0; i1<nums.length; i1++){
            if (nums[i1]%2==0) {
                nums[i1] = array_eve[cnt_eve];
                cnt_eve++;
            }else {
                nums[i1] = array_odd[cnt_odd];
                cnt_odd--;
            }
        }
        return nums;
    }

//    public static void lenSortV2(int[] inputs){
//
//    }

    public static void dg_odd(int[] inputs, int start, int end){
        int exchange, compare, i1, i2;
        if (start>end) return;
        i1 = start;
        i2 = end;
        compare = inputs[start];

        while (i1<i2){
            while (compare>=inputs[i2] && i1<i2) i2--;
            while (compare<=inputs[i1] && i1<i2) i1++;
            if (i1<i2){
                exchange = inputs[i1];
                inputs[i1] = inputs[i2];
                inputs[i2] = exchange;
            }
        }
        inputs[start] = inputs[i1];
        inputs[i1] = compare;
        dg_odd(inputs, start, i1-1);
        dg_odd(inputs, i1+1, end);
    }

    public static void main(String[] a){
        System.out.println(Arrays.toString(sortEvenOdd(new int[]{4,1,2,3,1})));
    }
}
