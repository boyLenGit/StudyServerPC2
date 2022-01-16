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
        for (int i1=0; i1<=list_in.size()-words.length; i1++){
            compares = new ArrayList<String>(Arrays.asList(words));
            if (compares.contains(list_in.get(i1))){
                for (int i2=i1; i2<i1+words.length; i2++){
                    if (compares.contains(list_in.get(i2))){
                        compares.remove(compares.indexOf(list_in.get(i2)));
                        if (compares.size()==0){
                            result.add(i1*len_word);
                            break;
                        }
                    }else break;
                }
            }
        }
        return result;
    }

    public static List<Integer> findSubstring2(String s, String[] words) {
        String sub = "";
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<String> compares = new ArrayList<String>(Arrays.asList(words));
        for (int i1=0; i1+words[0].length()<s.length(); i1++){
            sub = s.substring(i1, i1+words[0].length());
            if (compares.contains(sub) & (i1+words.length*words[0].length())<s.length()){
                for (int i2=0; i2<words.length; i2++){
                    if (compares.contains(sub)){
                        compares.remove(compares.indexOf(sub));
                        if (compares.size()==0){
                            result.add(i1);
                            break;
                        }
                        i1 = i1+words[0].length();
                        sub = s.substring(i1, i1+words[0].length()+1);
                    }else break;
                }
            }
        }
        return result;
    }


    public static void main(String[] args){
        System.out.println(findSubstring2("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo","barr","wing","ding","wing"}));
    }
}
//"wordgoodgoodgoodbestword"
//["word","good","best","good"]
// "lingmindraboofooowingdingbarrwingmonkeypoundcake"
//["fooo","barr","wing","ding","wing"]