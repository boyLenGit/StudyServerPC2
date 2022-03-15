package leet;

import util.LenLog;

import java.util.Arrays;
import java.util.List;

public class l011 {
    public static int maxArea(int[] height) {
        long volume = 0L;
        long volume_temp = 0L;
        int lower_height = 0;
        for (int i1=0; i1<height.length; i1++){
            for (int i2=i1; i2<height.length; i2++){
                lower_height = Math.min(height[i1], height[i2]);
                volume_temp = (long) ((i2 - i1) * lower_height);
                volume = Math.max(volume_temp, volume);
            }
        }
        return (int)volume;
    }
    // 超出时间限制


    public static int maxArea_len2(int[] height) {
        // 双指针法
        long volume = 0L;
        long volume_temp;
        for (int i1=0, i2=height.length-1; i1<i2; ){
            volume_temp = (i2 - i1) * Math.min(height[i1], height[i2]);
            volume = Math.max(volume_temp, volume);
            if (height[i1]>height[i2]){
                i2--;
            }else {
                i1++;
            }
        }
        return (int)volume;
    }


    public static int maxArea_leetcode_dalao1(int[] a) {
        int max = 0;
        for(int i = 0, j = a.length - 1; i < j; ){
            int minHeight = a[i] < a[j] ? a[i++] : a[j--];
            max = Math.max(max, (j - i + 1) * minHeight);
        }
        return max;
    }


    public int maxArea_leetcode_dalao2(int[] height) {
        //初始面积
        int area  = 0;
        for (int start = 0, end = height.length-1; start<end;) {
            area = Math.max(area, (end - start) * Math.min(height[start], height[end]));
            if (height[start] < height[end]){
                start++;
            }else {
                end--;
            }
        }
        return area;
    }


    public static void main(String[] args) {
        int[] input1 = {2,4,6,8,100};
        int result = maxArea_len2(input1);
        LenLog.printString(String.valueOf(result));

        List<String> strings = Arrays.asList("dfd", "ddsf");
        String[] strings1 = {"dfd", "ddsf"};
        System.out.println(strings);
        System.out.println(Arrays.toString(strings1));
    }
}
// 0 1 2 3 4 5