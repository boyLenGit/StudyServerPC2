package leet;

import java.util.ArrayList;
import java.util.Arrays;

public class l394 {
    public static String decodeString(String s) {
        char[] inputs = s.toCharArray();
        String str_in = s;
        String left = "";
        String right = "";
        String middle = "";
        String middle_temp = "";
        int ab_sum = 0;
        int isStart = 0;
        int right_index_fix = 0;
        ArrayList<Integer> a_index = new ArrayList<>();
        ArrayList<Integer> b_index = new ArrayList<>();
        for (int i1=0; i1<inputs.length; i1++){
            if (inputs[i1]=='[') {
                ab_sum++;
                a_index.add(i1);
                isStart = 1;
            }
            else if (inputs[i1]==']') {
                ab_sum--;
                b_index.add(i1);
            }
            // 开始进行解码
            if (isStart==1 & ab_sum==0){
                for (int i2=a_index.size()-1, i2_right=0; i2>=0; i2--, i2_right++){
                    left = str_in.substring(0, a_index.get(i2)-1);
                    right = str_in.substring(b_index.get(i2_right)+1-right_index_fix, str_in.length());
                    middle = str_in.substring(a_index.get(i2)+1, b_index.get(i2_right)-right_index_fix);
                    middle_temp = "";
                    // 生成32[]前面的32
                    int index_while = 0;
                    int debug = a_index.get(i2) - 1 - index_while;
                    while (inputs[a_index.get(i2) - 1 - index_while]>='0' & inputs[a_index.get(i2) - 1 - index_while]<='9' & (a_index.get(i2) - 1 - index_while)>=0) index_while++;
                    int i3_full = Integer.parseInt(str_in.substring(a_index.get(i2)-index_while,a_index.get(i2)));
                    // 将3[a]生成aaa
                    for (int i3 = 0; i3<(int)inputs[a_index.get(i2) - 1]-'0'; i3++){
                        middle_temp = middle_temp.concat(middle);
                    }
                    str_in = left + middle_temp + right;
                    right_index_fix = (b_index.get(i2_right)-right_index_fix - a_index.get(i2) + 2) - ((int)inputs[a_index.get(i2) - 1]-'0')*(b_index.get(i2_right)-right_index_fix - a_index.get(i2) - 1);
                }
                isStart = 0;
                inputs = str_in.toCharArray();
                i1 = 0;
                right_index_fix = 0;
                a_index.clear();
                b_index.clear();
            }
        }
        return str_in;
    }

    public static void main(String[] a){
        System.out.println(decodeString("232[abc]3[cd]ef"));
    }
}
// 3[a2[c]b]
// 012345678
//    ^  ^
// 3[accb]
// 0123456