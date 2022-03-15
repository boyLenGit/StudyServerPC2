package competition.No281;

import java.util.Arrays;

public class c6014 {
    public static String repeatLimitedString(String s, int repeatLimit) {
        char[] inputs = s.toCharArray();
        Arrays.sort(inputs);
        int repeatCount = 1;
        int index_repeat = s.length()-1;
        char exchange;
        for (int i1=inputs.length-1; i1>=0; i1--){
            if (i1!=inputs.length-1 && inputs[i1+1]!='0'){
                if (inputs[i1]==inputs[i1+1]) repeatCount++;
                else repeatCount=1;
            }
            if (repeatCount>repeatLimit){
                boolean isEdge = true;
                index_repeat = Math.min(index_repeat, i1 - 1);
                for (int i2=index_repeat; i2>=0; i2--){
                    if (inputs[i2]!=inputs[i1]){
                        exchange = inputs[i1];
                        inputs[i1] = inputs[i2];
                        inputs[i2] = exchange;
                        isEdge = false;
                        repeatCount = 1;
                        index_repeat = i2+1;
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
        System.out.println(repeatLimitedString("zyzyzyxyxyxyxwxwxwxvxvxuxututststsrsrsrqrqrpopopopopopopononmnmlklkljljljijijijhghghghghfhfefefdfdfcfcbab", 1));
    }
}
//"robnsdvpuxbapuqgopqvxdrchivlifeepy"
//2
// "bplpcfifosybmjxphbxdltxtfrjspgixoxzbpwrtkopepjxfooazjyosengdlvyfchqhqxznnhuuxhtbrojyhxwlsrklsryvmufoibgfyxgjw"
//1