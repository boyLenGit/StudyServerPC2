package competition.No281;

import java.util.Arrays;

public class c6014 {
    public static String repeatLimitedString(String s, int repeatLimit) {
        char[] inputs = s.toCharArray();
        Arrays.sort(inputs);
        int repeatCount = 1;
        int index_repeat = 0;
        char exchange;
        for (int i1=inputs.length-1; i1>=0; i1--){
            if (i1!=inputs.length-1 && inputs[i1+1]!='0'){
                if (inputs[i1]==inputs[i1+1]) repeatCount++;
                else repeatCount=1;
            }
            if (repeatCount>repeatLimit){
                boolean isEdge = true;
                for (int i2=i1-1; i2>=0; i2--){
                    if (inputs[i2]!=inputs[i1]){
                        exchange = inputs[i1];
                        inputs[i1] = inputs[i2];
                        inputs[i2] = exchange;
                        isEdge = false;
                        repeatCount = 1;
                        break;
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
        System.out.println(repeatLimitedString("aaaaaabbbbbbb", 1));
    }
}
//"robnsdvpuxbapuqgopqvxdrchivlifeepy"
//2
// "bplpcfifosybmjxphbxdltxtfrjspgixoxzbpwrtkopepjxfooazjyosengdlvyfchqhqxznnhuuxhtbrojyhxwlsrklsryvmufoibgfyxgjw"
//1