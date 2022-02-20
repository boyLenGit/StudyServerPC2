package competition.No281;

import java.util.Arrays;

public class c6014 {
    public static String repeatLimitedString(String s, int repeatLimit) {
        char[] inputs = new char[s.length()];
        for (int i1=0; i1<s.length(); i1++){
            inputs[i1] = s.charAt(i1);
        }
        Arrays.sort(inputs);
        int repeatCount = 0;
        char exchange;
        for (int i1=inputs.length-1; i1>=0; i1--){
            if (i1!=inputs.length-1){
                if (inputs[i1]==inputs[i1+1]){
                    repeatCount++;
                }else repeatCount=0;
            }
            if (repeatCount>repeatLimit){
                exchange = inputs[i1];
                inputs[i1] = inputs[i1+1];
                inputs[i1+1] = exchange;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i1=inputs.length-1; i1>=0; i1--){
            sb.append(inputs[i1]);
        }
        return sb.toString();
    }

    public static void main(String[] arg){
        System.out.println(repeatLimitedString("cczazcc", 3));
    }
}
