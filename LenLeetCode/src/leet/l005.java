package leet;

import java.util.Arrays;

public class l005 {
    public static String longestPalindrome(String s) {
        int[] char_table = new int[256];
        Arrays.fill(char_table, -1);

        int indexHwArea = 0;
        int length = s.length();
        int[] input_list = new int[length];
        Arrays.fill(input_list, 0);
        for(int i=0; i<length; i++){
            int char_raw = s.charAt(i);
            int indexHwArea_temp = char_table[char_raw]!= -1 ? char_table[char_raw]+1 : indexHwArea;
            indexHwArea = Math.max(indexHwArea_temp, indexHwArea);
            input_list[i] = char_table[char_raw]!= -1 ? -char_raw : char_raw;
            

        }
        return null;
    }
}
