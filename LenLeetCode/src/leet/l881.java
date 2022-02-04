package leet;

import java.util.Arrays;

public class l881 {

    public int numRescueBoats(int[] people, int limit) {
        lenSort(people);
        return 0;
    }

    public static void main(String[] arg){
        int[] inputs = new int[]{3,5,3,4};
        System.out.println(Arrays.toString(inputs));
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
            while (compare>=inputs[i2] & i1<i2) i2--;
            while (compare<=inputs[i1] & i1<i2) i1--;
            if (i1<i2){
                exchange = inputs[i2];
                inputs[i2] = inputs[i1];
                inputs[i1] = exchange;
            }
        }

        inputs[start] = inputs[i1];
        inputs[i1] = compare;

        dg(inputs, start, i1-1);
        dg(inputs, i1+1, end);
    }
}
