package leet;

public class l003 {
    public static int lengthOfLongestSubstring(String s) {
        char[] chars_input = s.toCharArray();
        int st_length = chars_input.length;
        int dy_length = chars_input.length;
        int isRepeat = 0; // 1则重复，0则无重复
        while (true){
            for(int i1=0; i1<(int)st_length/dy_length; i1++){
                // 遍历每一组的chars
                char[] chars_temp;
                String string_temp;
                // 提取出
                for(int i2=i1; i2<dy_length; i2++){
                    // 表明有重复
                    if(chars_input[i1]==chars_input[i2]){
                        isRepeat=1;
                        break;
                    }
                }
                // 如果循环完了没有重复的，则表明是最大非重复序列
                if (isRepeat==0){
                    return 
                }
            }
            dy_length--;
        }
    }
}
