package leet;

import java.util.Arrays;

public class l066 {
    public static int[] plusOne(int[] digits) {
        //if (digits.length==0) return
        for (int i1=digits.length-1; i1>=0;i1--){
            if (digits[i1]==9 ){
                digits[i1]=0;
            }else {
                digits[i1] = digits[i1]+1;
                return digits;
            }
        }
        if (digits[0]==0){
            int[] a=new int[digits.length+1];
            a[0]=1;
            System.arraycopy(digits, 0, a, 1, digits.length);
            return a;
        }
        return digits;
    }

    public static void main(String[] GHWEDFYT){

        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9})));
    }
}
