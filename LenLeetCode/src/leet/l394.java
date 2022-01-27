package leet;

import java.util.ArrayList;
import java.util.Arrays;

public class l394 {
    public static String decodeString(String s) {
        // [X] 这种从外向内替换的方式, 无法对付4[2[jk]e1[f]]]的情况
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
                    // 生成32[]前面的32
                    int index_length = 0;
                    while (inputs[a_index.get(i2) - 1 - index_length]>='0' & inputs[a_index.get(i2) - 1 - index_length]<='9') {
                        index_length++;
                        if (a_index.get(i2) - 1 - index_length<0) break;
                    }
                    int i3_full = Integer.parseInt(str_in.substring(a_index.get(i2)-index_length, a_index.get(i2)));
                    // 生成32[a]的左侧\右侧\中间内容
                    int debug = a_index.get(i2)-index_length;
                    left = str_in.substring(0, a_index.get(i2)-index_length);
                    int debug2 = b_index.get(i2_right)+1-right_index_fix;
                    right = str_in.substring(b_index.get(i2_right)+1-right_index_fix, str_in.length());
                    middle = str_in.substring(a_index.get(i2)+1, b_index.get(i2_right)-right_index_fix);
                    middle_temp = "";
                    // 将3[a]生成aaa
                    for (int i3 = 0; i3<i3_full; i3++){
                        middle_temp = middle_temp.concat(middle);
                    }
                    str_in = left + middle_temp + right;
                    right_index_fix = (b_index.get(i2_right)-right_index_fix - a_index.get(i2) + 2) - i3_full*(b_index.get(i2_right)-right_index_fix - a_index.get(i2) - 1);
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

    public static String decodeString2(String s) {
        // 改成从内向外替换的方式, 成功.但是复杂度较高
        char[] inputs = s.toCharArray();
        String str_in = s;
        String left = "";
        String right = "";
        String middle = "";
        String middle_temp = "";
        ArrayList<Integer> a_index = new ArrayList<>();
        ArrayList<Integer> b_index = new ArrayList<>();
        for (int i1_s=0, i1_e=i1_s+1; i1_e<inputs.length; ){
            if (inputs[i1_s]=='['){
                if (inputs[i1_e]=='['){
                    i1_s = i1_e;
                    i1_e = i1_s+1;
                }else if (inputs[i1_e]==']'){ // 如果[]中不包含[与], 则启动3[a]转换aaa
                    // 生成32[]前面的32
                    int index_length = 0;
                    while (inputs[i1_s-1-index_length]>='0' & inputs[i1_s-1-index_length]<='9') {
                        index_length++;
                        if (i1_s-1-index_length<0) break;
                    }
                    int i3_full = Integer.parseInt(str_in.substring(i1_s-index_length, i1_s));
                    // 生成32[a]的左侧\右侧\中间内容
                    left = str_in.substring(0, i1_s-index_length);
                    right = str_in.substring(i1_e+1, str_in.length());
                    middle = str_in.substring(i1_s+1, i1_e);
                    middle_temp = "";
                    // 将3[a]生成aaa
                    for (int i3 = 0; i3<i3_full; i3++) middle_temp = middle_temp.concat(middle);
                    str_in = left + middle_temp + right;
                    inputs = str_in.toCharArray();
                    i1_s=0;i1_e=i1_s+1;continue;
                }
                i1_e++;
            }else { i1_s++;i1_e++; }
        }
        return str_in;
    }

    public static void main(String[] a){
        System.out.println(decodeString2("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }
}
// 3[a2[c]b]
// 012345678
//    ^  ^
// 3[accb]
// 0123456
// "3[z]2[2[y]pq4[2[jk]e1[f]]]ef"