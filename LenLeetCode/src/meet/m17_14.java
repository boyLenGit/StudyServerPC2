package meet;

import java.util.ArrayList;
import java.util.Arrays;

public class m17_14 {
    public static int[] smallestK(int[] arr, int k) {
        lenSort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }

    public static void lenSort(int[] inputs){
        dg(inputs, 0, inputs.length-1);
    }

    public static void dg(int[] inputs, int start, int end){
        int i1, i2, compare, exchange;
        if (start>end) return;
        i1 = start;
        i2 = end;
        compare = inputs[start];
        while (i1<i2){
            while (inputs[i2]>compare & i1<i2) i2--;
            while (inputs[i1]<compare & i1<i2) i1++;
            if (i1<i2){
                exchange = inputs[i1];
                inputs[i1] = inputs[i2];
                inputs[i2] = exchange;
            }
        }
        inputs[start] = inputs[i1];
        inputs[i1] = compare;
        // 左侧\右侧递归
        dg(inputs, start, i1-1);
        dg(inputs, i1+1, end);
    }

    public static void main(String[] art){
        int[] in1 = new int[]{};
        System.out.println(Arrays.toString(smallestK(in1,4)));
    }
}
