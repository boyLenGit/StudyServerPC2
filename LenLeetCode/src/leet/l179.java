package leet;

public class l179 {
    public static String largestNumber(int[] nums) {
        lenSort(nums);
        return "";
    }

    public static void lenSort(int[] inputs){
        dg(inputs, 0, inputs.length-1);
    }

    public static void dg(int[] inputs, int start, int end){
        int i1, i2, exchange, compare;
        if (start>end) return;
        i1 = start;
        i2 = end;
        compare = inputs[start];
        while (i1<i2){
            while (lenCompare(compare, inputs[i2]) & i1<i2) i2--;
            while (lenCompare(inputs[i1], compare) & i1<i2) i1++;
            if (i1<i2){
                exchange = inputs[i1];
                inputs[i1] = inputs[i2];
                inputs[i2] = exchange;
            }
        }
        inputs[start] = inputs[i1];
        inputs[i1] = compare;
        dg(inputs, start, i1-1);
        dg(inputs, i1+1, end);
    }

    public static boolean lenCompare(int num1, int num2){
        String str1 = String.valueOf(num1);
        String str2 = String.valueOf(num2);
        String str_short = num1>=num2 ? String.valueOf(num1) : String.valueOf(num2);
        String str_long =  num1>=num2 ? String.valueOf(num2) : String.valueOf(num1);
        char comp1, comp2;
        for (int i1=0, i2=0; i1<str1.length() | i2<str2.length(); i1++, i2++){
            comp1 = i1<str1.length() ? str1.charAt(i1) : str1.charAt(str1.length()-1);
            comp2 = i2<str2.length() ? str2.charAt(i2) : str2.charAt(str2.length()-1);
            if (comp1>comp2) return true;
            else if (comp1<comp2)return false;
        }
        return true;
    }

    public static void main(String[] arg){
        int[] inputs = new int[]{};
        System.out.println(largestNumber(inputs));
    }
}
