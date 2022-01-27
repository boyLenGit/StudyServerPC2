package leet;

import java.util.ArrayList;
import java.util.Arrays;

public class l394 {
    public static String decodeString(String s) {
        char[] inputs = s.toCharArray();
        char[] temp;
        String temp_temp = "";
        String str_in = s;
        String left = "";
        String right = "";
        String middle = "";
        String middle_temp = "";
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
                for (int i2=a_index.size()-1; i2>=0; i2--){
                    left = str_in.substring(0, a_index.get(i2)-1);
                    right = str_in.substring(b_index.get(i2), str_in.length());
                    middle = str_in.substring(a_index.get(i2)+1, b_index.get(i2));
                    middle_temp = "";
                    for (int i3 = 0; i3<(int)inputs[a_index.get(i2) - 1]; i3++){
                        middle_temp = middle_temp.concat(middle);
                    }
                    str_in = left + middle_temp + right;
                }
            }
        }
    }
}
// 3[a2[c]b]
// 012345678
//    ^  ^
// 3[accb]
// 0123456