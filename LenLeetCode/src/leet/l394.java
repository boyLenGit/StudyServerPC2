package leet;

import java.util.ArrayList;

public class l394 {
    public static String decodeString(String s) {
        char[] inputs = s.toCharArray();
        char[] temp;
        int ab_sum = 0;
        int a_sum = 0;
        int isStart = 0;
        ArrayList<Integer> a_index = new ArrayList<>();
        ArrayList<Integer> b_index = new ArrayList<>();
        for (int i1=0; i1<inputs.length; i1++){
            if (inputs[i1]=='[') {
                ab_sum++;
                a_sum++;
                a_index.add(i1);
                isStart = 1;
            }
            else if (inputs[i1]==']') {
                ab_sum--;
                b_index.add(i1);
            }
            // 开始进行解码
            if (isStart==1 & ab_sum==0){
                for (int i2=0; i2<a_sum; i2++){
                    temp = new char[b_index.get(i2)-a_index.get(i2)];
                }
            }
        }
    }
}
