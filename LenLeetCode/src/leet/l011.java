package leet;

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

    public static void main(String[] args) {
        int input1 = [1,8,6,2,5,4,8,3,7];
    }
}
// 0 1 2 3 4 5