package leet;

import java.util.ArrayList;
import java.util.List;

public class l017 {
    public static List<String> letterCombinations(String digits) {
        char[] inputs = digits.toCharArray();
        String[] strings_abcde = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<String>();
        // 遍历输入的字符数量
        for (int i1=0; i1<inputs.length; i1++){
            List<String> result_temp = new ArrayList<String>();
            char[] chars_single = strings_abcde[inputs[i1] - '0' - 2].toCharArray();  // "abc"→a b c
            // 当首次进入时，还没有存储内容
            if (i1==0){
                for (int i3=0; i3<chars_single.length; i3++){
                    result.add(String.valueOf(chars_single[i3]));
                }
                continue;
            }
            for (int i2=0; i2<result.size(); i2++){
                String string = result.get(i2);
                for (int i3=0; i3<chars_single.length; i3++){
                    result_temp.add(string.concat(String.valueOf(chars_single[i3])));
                }
            }
            result = result_temp;
        }
        return result;
    }

    public static void main(String[] args){
        List<String> result = letterCombinations("32");
        System.out.println(result);
    }
}
