package exam.weilai0810;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/10 13:05
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        String in = scanner.nextLine();
        String[] inNums = in.split(" ");
        int[] intNums = new int[inNums.length];
        for (int i1=0; i1<inNums.length; i1++){
            intNums[i1] = Integer.parseInt(inNums[i1]);
        }

        Arrays.sort(intNums);
        System.out.println(intNums[0]);
    }

    public static String[] func(int[] array, int last){
        String[] res = new String[array.length];
        int max = 0;
        for (int item: array){
            max = Math.max(item, max);
        }
        for (int i1=0; i1<array.length; i1++){
            if (array[i1]+last >= max){
                res[i1] = "True";
            }else {
                res[i1] = "False";
            }
        }
        return res;
    }
//    public static void func2(int num){
//        if (num>100000) {
//            System.out.println(-1);
//            return;
//        }
//        for (int i1=2; i1<num-1; i1++){
//            if (!isZhiShu(i1)) continue;
//            for (int i2=2; i2<num-1-i1; i2++){
//                if (!isZhiShu(i2)) continue;
//                for (int i3=2; i3<num-1-i1-i2; i3++){
//                    if (!isZhiShu(i3)) continue;
//                    int i4 = num-i1-i2-i3;
//                    if (isZhiShu(i1) && isZhiShu(i2) && isZhiShu(i3) && isZhiShu(i4)){
//                        System.out.println(i1 + " " + i2 + " " + i3 + " " + i4);
//                        return;
//                    }
//                }
//            }
//        }
//        System.out.println(-1);
//    }
//
//    public static boolean isZhiShu(int i){
//        if (i==2){
//            return true;
//        }else {
//            for (int i1=2; i1<i; i1++){
//                if (i%i1==0){
//                    return false;
//                }
//            }
//            return true;
//        }
//    }
//
//    public static void func(){
//        for (int i1=8; i1<=100; i1++){
//            for (int i2=2; i2<i1-1;i2++){
//                if (prime(i2)==1 && prime(i1-i2)==1){
//                    System.out.println(i1 + "=" + i2 + "+" + (i1-i2));
//                }
//            }
//        }
//    }
//
//    public static int prime(int i){
//        if (i==2){
//            return 1;
//        }else {
//            for (int i1=2; i1<i; i++){
//                if (i%i1==0){
//                    return 0;
//                }
//            }
//            return 1;
//        }
//    }
}
