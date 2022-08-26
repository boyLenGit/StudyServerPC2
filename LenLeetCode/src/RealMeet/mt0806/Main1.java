package RealMeet.mt0806;

import java.util.Scanner;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/6 10:03
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int groupNum = scanner.nextInt();
        for (int i=0; i<groupNum; i++){
            Integer num1 = scanner.nextInt();
            Integer num2 = scanner.nextInt();
            System.out.println(func(num1, num2));
        }
    }

    public static Integer func(Integer num1, Integer num2){
        int big = num1 >= num2 ? num1 : num2;
        int small = num1 >= num2 ? num2 : num1;
        int res = 0;
        if (big < 0 || small < 0){
            return res;
        }
        int temp;
        if (big >= small * 2){
            return small;
        }

        while (true){
            big -= 2;
            small -= 1;
            if (big < 0 || small < 0){
                return res;
            }
            res ++;
            if (big == small){
                return (res + (big + small)/3);
            }
            if (big < small){
                temp = big;
                big = small;
                small = temp;
            }
        }
    }
}
// 5 6
// 122 4 4
//