package JZoffer;

import java.util.Arrays;

public class jz040 {
    public static int[] getLeastNumbers(int[] arr, int k) {
        lenQuickSortDG(arr, 0, arr.length-1);
        return Arrays.copyOfRange(arr, 0, k);
    }

    public static void lenQuickSortDG(int[] inputs, int start, int end){
        int i1=start, i2=end, exchange, compare;
        if (start>end)return;
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
        lenQuickSortDG(inputs, start, i1-1);
        lenQuickSortDG(inputs, i1+1, end);
    }

    public static int[] getLeastNumbers2(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }

    public static void main(String[] arg){
        int[] inputs = new int[]{3,2,1,2,3,5,7,88,99,4,3,5,7,0,9};
        System.out.println(Arrays.toString(getLeastNumbers(inputs, 2)));
    }
}
