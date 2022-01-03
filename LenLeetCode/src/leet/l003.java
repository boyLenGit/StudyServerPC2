package leet;

import leet.help.ListNode;

public class l003 {
    public static int lengthOfLongestSubstring(String s) {
        char[] chars_input = s.toCharArray();
        int st_length = chars_input.length;
        int dy_length = chars_input.length;
        int isRepeat = 0; // 1则重复，0则无重复
        while (true){
            if(dy_length==1){
                return 1;
            }
            if(dy_length<=0){
                return 0;
            }
            int for_time = (st_length%dy_length)==0 ? st_length/dy_length : (st_length/dy_length)+1;
            // 遍历某一长度下每一组的chars
            for(int i1=0; i1<for_time; i1++){
                // 遍历每一组的单个chars
                for(int i2=i1; i2<dy_length+i1; i2++){
                    for(int i2_2=i2+1; i2_2<dy_length+i1; i2_2++){
                        // 表明有重复
                        if(chars_input[i2]==chars_input[i2_2]){
                            isRepeat = 1;
                            break;
                        }
                    }
                    if(isRepeat==1){
                        break;
                    }
                }
                // 如果循环完了没有重复的，则表明是最大非重复序列
                if (isRepeat==0){
                    return dy_length;
                }
                isRepeat = 0;
            }
            dy_length--;
        }
    }

    public static void main(String[] args) {
        int result = lengthOfLongestSubstring("pwwkew");
        System.out.println(result);
    }
}
