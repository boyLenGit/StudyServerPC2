package RealMeet.netease0820;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/20 15:25
 * 1 2 3 4 5
 * 12345
 * 00 01 02 03 04 , 10 11 12 13 14
 * int[] 表示删除第几个,每项表示操作第几次
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(" ");

        System.out.println(func(inputs[0], inputs[1]));
    }

    public static int func(String num1, String num2){
        StringBuilder bigger = new StringBuilder(num1.length() >= num2.length() ? num1 : num2);
        StringBuilder smaller = new StringBuilder(num1.length() >= num2.length() ? num2 : num1);
        if (isBeiShu(bigger, smaller)){
            return 0;
        }
        int[] signs = new int[bigger.length()];
        Arrays.fill(signs, -1);
        for (int subTime=1; subTime<bigger.length(); subTime++){
            // 初始化
            for (int i1=0; i1< subTime; i1++){
                signs[i1] = 0;
            }

            for (int i1=0; i1<subTime; i1++){
                StringBuilder tempBigger = new StringBuilder(num1.length() >= num2.length() ? num1 : num2);
                StringBuilder tempSmaller = new StringBuilder(num1.length() >= num2.length() ? num2 : num1);
                // 迭代处理
                boolean bool = addInts(signs, bigger.length(), subTime);
                if (!bool){
                    // 说明当前处理次数不满足
                    break;
                }else {
                    for (int i2=0; i2<subTime; i2++){
                        tempBigger.setCharAt(signs[i2], '-');
                    }
                    for (int i2=0; i2<tempBigger.length(); i2++){
                        if (tempBigger.charAt(i2)=='-'){
                            tempBigger.deleteCharAt(i2);
                            i2--;
                        }
                    }
                    if (isBigger(tempBigger, tempSmaller, bigger.length())){
                        if (isBeiShu(tempBigger, tempSmaller)){
                            return subTime;
                        }
                    }else {
                        if (isBeiShu(tempSmaller, tempBigger)){
                            return subTime;
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static boolean addInts(int[] nums, int max, int len){
        for (int i1=0; i1< len; i1++){
            if (nums[i1]<max){
                nums[i1]++;
                return true;
            }else {
                if (i1+1<len && nums[i1+1]<max){
                    nums[i1] = 0;
                    nums[i1+1] ++;
                }else {
                    return false;
                }
            }
        }
        return false;
    }

    public static boolean isBeiShu(StringBuilder bigger, StringBuilder smaller){
        int lianXuCnt = 0;
        for (int i1=smaller.length()-1; i1<bigger.length(); i1++){
            while (isBigger(bigger, smaller, i1)){
                subStringNum(bigger, smaller, i1);
            }
            lianXuCnt = lianXuZero(bigger, lianXuCnt);
            if (lianXuCnt == bigger.length()){
                return true;
            }
        }
        return false;
    }

    public static boolean isBigger(StringBuilder big, StringBuilder small, int len){
        int iB = 0;
        while (iB<big.length() && big.charAt(iB) == '0'){
            iB++;
        }
        if (len-iB+1<small.length()){
            return false;
        }else if (len-iB+1>small.length()){
            return true;
        }
        for (int iS=0; iS<small.length() && iB<=len; iS++, iB++){
            if (big.charAt(iB)<small.charAt(iS)){
                return false;
            }else if (big.charAt(iB)>small.charAt(iS)){
                return true;
            }
        }
        return true;
    }

    public static void subStringNum(StringBuilder bigger, StringBuilder smaller, int bigIndex){
        for (int iB = bigIndex, iS = smaller.length()-1; iB>=0 && iS>=0; iB--, iS--){
            int res = (bigger.charAt(iB) - '0') - (smaller.charAt(iS) - '0');
            if (res<0){
                bigger.setCharAt(iB-1, Character.forDigit(bigger.charAt(iB-1) - '0' - 1, 10));
                res += 10;
            }
            bigger.setCharAt(iB, Character.forDigit(res, 10));
        }
    }

    public static int lianXuZero(StringBuilder builder, int index){
        for (int i1=index; i1<builder.length(); i1++){
            if (builder.charAt(i1)!='0'){
                return i1;
            }
        }
        return builder.length();
    }
}
