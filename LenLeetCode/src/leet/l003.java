package leet;

public class l003 {
    public static int lengthOfLongestSubstring(String s) {
        char[] chars_input = s.toCharArray();
        int st_length = chars_input.length;
        int dy_length = chars_input.length;
        while (true){
            for(int i1=0; i1<(int)st_length/dy_length; i1++){
                // 遍历每一组的chars
                for(int i2=i1; i2<dy_length; i2++){
                    
                }
            }
            dy_length--;
        }
    }
}
