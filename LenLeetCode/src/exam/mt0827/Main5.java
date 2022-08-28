package exam.mt0827;

import java.util.Scanner;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/27 17:12
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLineNums = scanner.nextLine().split(" ");
        String[] positionsString = scanner.nextLine().split(" ");
        func(toInts(firstLineNums));
    }

    public static int[] toInts(String[] strings) {
        int[] res = new int[strings.length];
        for (int i1 = 0; i1 < strings.length; i1++) {
            res[i1] = Integer.parseInt(strings[i1]);
        }
        return res;
    }


    //    public static List<Integer> func(int len, int times, int[] positions){
//
//    }
    public static int func(int[] array) {
        int res = 0;
        int resTemp = 0;
        boolean isLeft = true;
        boolean isNeg = false;
        boolean isPos = false;
        System.out.println(102);
        if (array.length > 0) return 0; // test
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                isNeg = true;
                if (isLeft) {
                    resTemp++;
                } else {
                    isLeft = true;
                    res = Math.max(res, resTemp);
//                    res += resTemp;
                    resTemp = 0;
                }
            } else if (array[i] > 0) {
                isPos = true;
                if (!isLeft) {
                    resTemp++;
                } else {
                    if (res == 0 && resTemp == 0) {
                        continue;
                    }
                    isLeft = false;
                    resTemp++;
                }
            } else { // array[i] == 0的情况
                isLeft = true;
                res = Math.max(res, resTemp);
//                res += resTemp;
                resTemp = 0;
            }
        }
        if (!isLeft && resTemp != 0) { // 在右侧且resTemp不为零
//            res += resTemp;
            res = Math.max(res, resTemp);
        }
        if (!isNeg || !isPos) {
            return array.length;
        }
        return array.length - res;
    }
}
