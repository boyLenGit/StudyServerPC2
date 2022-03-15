package leet;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class l030 {

    public static List<Integer> findSubstring2(String s, String[] words) {
        // 思路：按字符向后遍历，每次遍历都截取后一段字符，判断是否等于words，是则进入遍历words循环
        String sub = "";
        int cnt = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<String> compares = new ArrayList<String>(Arrays.asList(words));
        for (int i1=0; i1+words[0].length()<=s.length(); i1++){
            compares = new ArrayList<String>(Arrays.asList(words));
            sub = s.substring(i1, i1+words[0].length());
            int debug1 = i1+words.length*words[0].length();
            int debug2 = s.length();
            int debug3 = i1+words[0].length();
            if (compares.contains(sub) & (i1+words.length*words[0].length())<=s.length()){
                cnt = i1;
                for (int i2=0; i2<words.length; i2++){
                    if (compares.contains(sub)){
                        compares.remove(compares.indexOf(sub));
                        if (compares.size()==0){
                            result.add(i1);
                            break;
                        }
                        cnt = cnt+words[0].length();
                        sub = s.substring(cnt, cnt+words[0].length());
                    }else break;
                }
            }
        }
        return result;
    }


    public static void main(String[] args){
        System.out.println(findSubstring2("a", new String[]{"a"}));
    }
}
//"wordgoodgoodgoodbestword"
//["word","good","best","good"]
// "lingmindraboofooowingdingbarrwingmonkeypoundcake"
//["fooo","barr","wing","ding","wing"]
// "wordgoodgoodgoodbestword"
//["word","good","best","good"]
// "a"
//["a"]