package RealMeet.mt0806;

import java.util.Scanner;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/6 10:24
 */
public class Main2 {
    //5
    //0 -1 1 1 -1 0 -1 1 1 -1  = 7
    // 5
    // -1 1 0 -1 -1 +
    // 1 -1 1 -1 1
    // 0 0 0 0 0
    // -1 1 0 -1 -1 1
    // 1 -1 1 1 0 -1 -1 1
    //
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i<length; i++){
            array[i] = scanner.nextInt();
        }
        System.out.println(func(array));
    }

    public static int func(int[] array){
        int res = 0;
        int resTemp = 0;
        boolean isLeft = true;
        boolean isNeg = false;
        boolean isPos = false;
        for (int i = 0; i<array.length; i++){
            if (array[i]<0){
                isNeg = true;
                if (isLeft){
                    resTemp++;
                }else {
                    isLeft = true;
                    res = Math.max(res, resTemp);
//                    res += resTemp;
                    resTemp = 0;
                }
            }else if (array[i]>0){
                isPos = true;
                if (!isLeft){
                    resTemp++;
                }else {
                    if (res == 0 && resTemp == 0){
                        continue;
                    }
                    isLeft = false;
                    resTemp++;
                }
            }else{ // array[i] == 0的情况
                isLeft = true;
                res = Math.max(res, resTemp);
//                res += resTemp;
                resTemp = 0;
            }
        }
        if (!isLeft && resTemp!=0){ // 在右侧且resTemp不为零
//            res += resTemp;
            res = Math.max(res, resTemp);
        }
        if (!isNeg || !isPos) {
            return array.length;
        }
        return array.length - res;
    }
}

/**
 * 小美的实验结果
 * 题目描述：
 *         小美在做一个实验，这个实验会在纸带上打印出若干个数字，已知该实验所呈现出的正确结果应该是存在某一个分割处k，在k之前打印出的数字都是小于0的，而在k之后的数字应该都是大于0的，那么在k之前如果某一个数据大于等于0，那么我们认为这个数据是异常的，同理，在k之后如果某一个数据小于等于0，那么我们也认为这个数据是异常的。
 *
 *         现在给出小美打印的纸带，且k是未知的，那么请问在最乐观的情况下至少有多少个实验数据是异常的。(显然如果出现0，无论k为哪个时刻，这个0数据都是异常的)
 *
 * 输入描述
 *     输入第一行包含一个正整数n，表示小美在纸带上打印的数字数量。(1<=n<=100000)
 *
 *     输入第二行包含n个整数 ，即小美在纸带上打印的数字，中间用空格隔开。数字仅会为 -1，0，1中的一个。
 *
 * 输出描述
 * 输出仅包含一个整数，表示至少有多少个实验数据是异常的。
 *
 * 样例输入
 * 5
 * 0 -1 1 1 -1
 * 样例输出
 * 2
 *
 * 提示
 * 在最乐观的情况下，k应该在第二个和第三个数字之间，此时第一个和最后一个数据是异常的。
 */