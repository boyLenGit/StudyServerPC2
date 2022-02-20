package competition.No281;

import java.util.Arrays;

public class c6014 {
    public static String repeatLimitedString(String s, int repeatLimit) {
        char[] inputs = s.toCharArray();
        Arrays.sort(inputs);
        int repeatCount = 1;
        char exchange;
        for (int i1=inputs.length-1; i1>=0; i1--){
            if (i1!=inputs.length-1 && inputs[i1+1]!='0'){
                if (inputs[i1]==inputs[i1+1]) repeatCount++;
                else repeatCount=1;
            }
            if (repeatCount>repeatLimit){
                boolean isEdge = true;
                int i_diff = 0;
                for (int i2=i1-1; i2>=0; i2--){
                    if (inputs[i2]!=inputs[i1]){
                        exchange = inputs[i1];
                        inputs[i1] = inputs[i2];
                        inputs[i2] = exchange;
                        i_diff = i2-1;
                        isEdge = false;
                        break;
                    }
                }
//                int i_repeat = i1-1;
//                for (int i3=i_repeat; i3>=0; i3--){
//                    if (inputs[i3]==inputs[i1+1]){
//                        if (i_diff<=0) break;
//                        exchange = inputs[i3];
//                        inputs[i3] = inputs[i_diff];
//                        inputs[i_diff--] = exchange;
//                        i1 = i3;
//                    }
//                }
                if (isEdge) inputs[i1] = '0';
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i1=inputs.length-1; i1>=0; i1--){
            if (inputs[i1]!='0') sb.append(inputs[i1]);
        }
        return sb.toString();
    }

    public static String repeatLimitedString2(String s, int repeatLimit) {
        char[] inputs = s.toCharArray();
        Arrays.sort(inputs);
        int repeatCount = 1;
        char exchange;
        for (int i1=inputs.length-1; i1>=0; i1--){
            if (i1!=inputs.length-1 && inputs[i1+1]!='0'){
                if (inputs[i1]==inputs[i1+1]) repeatCount++;
                else repeatCount=1;
            }
            if (repeatCount>repeatLimit){
                boolean isEdge = true;
                int i_diff = 0;
                for (int i2=i1-1; i2>=0; i2--){
                    if (inputs[i2]!=inputs[i1]){
                        i_diff = i2;
                        isEdge = false;
                        break;
                    }
                }
                int i_repeat = i1;
                for (int i3=i_repeat; i3>=0; i3--){
                    if (inputs[i3]==inputs[i_repeat+1]){
                        if (i_diff<=0) break;
                        exchange = inputs[i3];
                        inputs[i3] = inputs[i_diff];
                        inputs[i_diff] = exchange;
                        i_diff--;
                        i1 = i3;
                    }
                }
                if (isEdge) inputs[i1] = '0';
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i1=inputs.length-1; i1>=0; i1--){
            if (inputs[i1]!='0') sb.append(inputs[i1]);
        }
        return sb.toString();
    }

    public static void main(String[] arg){
        System.out.println("zyzyzyxyxyxyxwxwxwxvxvxuxututststsrsrsrqrqrpopopopopopopononmnmlklkljljljijijijhghghghghfhfefefdfdfcfcbab");
        System.out.println(repeatLimitedString2("aababab", 2));
    }
}
//"robnsdvpuxbapuqgopqvxdrchivlifeepy"
//2
// "bplpcfifosybmjxphbxdltxtfrjspgixoxzbpwrtkopepjxfooazjyosengdlvyfchqhqxznnhuuxhtbrojyhxwlsrklsryvmufoibgfyxgjw"
//1