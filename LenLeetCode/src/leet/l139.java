package leet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class l139 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String, Integer> map = new HashMap<>();
        int word_max = 0, word_min = 9999;
        for (String item: wordDict){
            map.put(item, 1);
            word_max = Math.max(word_max, item.length());
            word_min = Math.min(word_min, item.length());
        }
        boolean res = dg(s, 0, word_max, word_min, map);
        return res;
    }

    public static boolean dg(String s, int start, int max, int min, HashMap<String, Integer> map){
        boolean res = false;
        for (int i1=start, i2=i1+min; i2<=s.length(); i2++){
            String debug = s.substring(i1, i2);
            if (map.containsKey(s.substring(i1, i2))){
                if (i2==s.length()) return true;
                res = dg(s, i2, max, min, map);
                if (res) return true;
            }
            if (i2-i1>max){
                return res;
            }
        }
        return res;
    }

    public static void main(String[] arg){
        List<String> inputs = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
        System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", inputs));
    }
}
// "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
//["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]