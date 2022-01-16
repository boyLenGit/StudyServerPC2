package leet;

import java.util.ArrayList;
import java.util.List;

public class l030 {
    public static List<Integer> findSubstring(String s, String[] words) {
        ArrayList<String> list_in = new ArrayList<String>();
        int len_word = words[0].length();
        int start=0;
        int end=0;
        for (int i1=0; i1<s.length()/words[0].length(); i1++){
            start = i1*len_word;
            end = (i1+1)*len_word+1;
            list_in.add(i1, s.substring(i1*len_word, (i1+1)*len_word));
        }
        return new ArrayList<Integer>();
    }

    public static void main(String[] args){
        System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo","bar"}));
    }
}
