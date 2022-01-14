package leet;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l022 {
    public static List<String> generateParenthesis(int n) {
        char[] chars = new char[n*2];
        Arrays.fill(chars, '?');
        ArrayList<char[]> list_2v = new ArrayList<>();
        list_2v.add(chars);
        int[] ints = new int[n*2];
        List<String> result = new ArrayList<String>();
        for (int i1=0; i1<n; i1++){
            ArrayList<char[]> list_2v_temp = new ArrayList<>();
            for (int i2=0; i2<list_2v.size(); i2++){
                char[] chars_temp = list_2v.get(i1);
                for (int start=String.valueOf(chars).indexOf("?"), end=start+1; end<chars_temp.length; end=end+2){
                    chars_temp[start] = '(';
                    chars_temp[end] = ')';
                    if (end+1>=chars_temp.length) break;
                    else if (chars_temp[end+1]!='?') break;
                    list_2v_temp.add(chars_temp);
                }
            }
            list_2v = list_2v_temp;
        }
        return new ArrayList<>();
    }

    public static void main(String[] args){
        generateParenthesis(3);
    }
}
// 012345
// ()
// (  )
// (    )
//      ((  ))
//      (()  )