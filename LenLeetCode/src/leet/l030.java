package leet;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class l030 {
    public static List<Integer> findSubstring(String s, String[] words) {
        // 提取出单词组成一个list
        ArrayList<String> list_in = new ArrayList<String>();
        int len_word = words[0].length();
        for (int i1=0; i1<s.length()/words[0].length(); i1++){
            list_in.add(i1, s.substring(i1*len_word, (i1+1)*len_word));
        }
        //计算有没有符合要求的
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<String> compares = new ArrayList<String>(Arrays.asList(words));
        for (int i1=0; i1<list_in.size(); i1++){
            for (int i2=0; i2<words.length; i2++){
                if (compares.contains(list_in.get(i1))){
                    compares.remove(list_in.get(i1));
                }
            }

            if (compares.contains(list_in.get(i1))){
                compares.remove(list_in.get(i1));
                result.add(i1*len_word);
                if (compares.size()==0){
                    return result;
                }
            }else {
                compares = new ArrayList<String>(Arrays.asList(words));
                result = new ArrayList<Integer>();
            }
        }
        return new ArrayList<Integer>();
    }

    public static void main(String[] args){
        System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo","bar"}));
    }
}
