package leet;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class l022 {
    public static List<String> generateParenthesis(int n) {
        char[] chars = new char[n*2];
        Arrays.fill(chars, 'a');
        ArrayList<char[]> list_2v = new ArrayList<>();
        list_2v.add(chars);
        for (int i1=0; i1<n; i1++){
            ArrayList<char[]> list_2v_temp = new ArrayList<>();
            for (int i2=0; i2<list_2v.size(); i2++){
                char[] chars_temp = Arrays.copyOf(list_2v.get(i2), list_2v.get(i2).length);
                for (int start=String.valueOf(chars_temp).indexOf("a"), end=start+1; end<chars_temp.length; end=end+2){
                    if (start==-1) break;
                    chars_temp[start] = '(';
                    chars_temp[end] = ')';
                    list_2v_temp.add(chars_temp);
                    chars_temp = Arrays.copyOf(list_2v.get(i2), list_2v.get(i2).length);
                    if (end+1>=chars_temp.length) break;
                    else if (chars_temp[end+1]!='a') break;
                }
            }
            list_2v = new ArrayList<>();
            for (int i_init=0; i_init<list_2v_temp.size(); i_init++){
                list_2v.add(chars);
            }
            Collections.copy(list_2v, list_2v_temp);
        }
        // 将char[]变为string
        List<String> result = new ArrayList<String>();
        for (char[] value : list_2v) {
            result.add(String.valueOf(value));
        }
        return result;
    }

    public static void main(String[] args){
        char[] chars = {'c', 'f', 'f'};
        System.out.println(String.valueOf(chars).indexOf("f"));
        generateParenthesis(3);
    }
}
// 原理：
// ()
// (  )
// (    )
//      ((  ))
//      (()  )