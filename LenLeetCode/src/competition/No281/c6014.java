package competition.No281;

import java.util.Arrays;

public class c6014 {
    public static String repeatLimitedString(String s, int repeatLimit) {
        char[] inputs = new char[s.length()];
        for (int i1=0; i1<s.length(); i1++){
            inputs[i1] = s.charAt(i1);
        }
        Arrays.sort(inputs);
        int repeatCount = 1;
        char exchange;
        // 逆向
        for (int i1=inputs.length-1; i1>=0; i1--){
            if (i1!=inputs.length-1){
                if (inputs[i1]==inputs[i1+1]){
                    repeatCount++;
                }else repeatCount=1;
            }
            if (repeatCount>repeatLimit){
                for (int i2=i1; i2>=0; i2--){
                    if (inputs[i2]!=inputs[i1]){
                        exchange = inputs[i1];
                        inputs[i1] = inputs[i2];
                        inputs[i2] = exchange;
                    }
                }
            }
        }
//        // 正向
//        for (int i1=0; i1<inputs.length; i1++){
//            if (i1!=0){
//                if (inputs[i1]==inputs[i1-1]){
//                    repeatCount++;
//                }else repeatCount=1;
//            }
//            if (repeatCount>repeatLimit){
//                for (int i2=i1; i2<inputs.length; i2++){
//                    if (inputs[i2]!=inputs[i1]){
//                        exchange = inputs[i1];
//                        inputs[i1] = inputs[i2];
//                        inputs[i2] = exchange;
//                    }
//                }
//            }
//        }
        StringBuilder sb = new StringBuilder();
        for (int i1=inputs.length-1; i1>=0; i1--){
            sb.append(inputs[i1]);
        }
        return sb.toString();
    }

    public static void main(String[] arg){
        System.out.println(repeatLimitedString("aababab", 2));
    }
}
