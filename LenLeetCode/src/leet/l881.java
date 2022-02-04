package leet;

import java.util.Arrays;

public class l881 {
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int sum=0, res=0, people_num=0;
        for (int i1=0, i2=people.length-1; i1<=i2;){
            if (sum+people[i2]<=limit & people_num!=2) {
                sum += people[i2];
                i2--;
                people_num++;
                continue;
            }


            if (sum+people[i1]>limit | sum==limit | people_num==2){
                res++;
                sum=0;
                people_num=0;
            }else {
                sum += people[i1];
                i1++;
                people_num++;
            }
        }
        if (sum!=0) res++;
        return res;
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
            while (compare<=inputs[i2] & i1<i2) i2--;
            while (compare>=inputs[i1] & i1<i2) i1++;
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



    public static void main(String[] arg){
        int[] inputs = new int[]{2,49,10,7,11,41,47,2,22,6,13,12,33,18,10,26,2,6,50,10};
        System.out.println(numRescueBoats(inputs, 50));
    }
}
// [5,1,4,2]
//6
//3,2,2,1
// [2,49,10,7,11,41,47,2,22,6,13,12,33,18,10,26,2,6,50,10]
//50