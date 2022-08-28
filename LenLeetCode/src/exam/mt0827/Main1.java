package exam.mt0827;

import java.util.Scanner;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/27 16:10
 * a
 * aabcdd
 * a***d
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strNums = scanner.nextLine().split(" ");
        String fullStr = scanner.nextLine();
        String matcher = scanner.nextLine();
        System.out.println(func(fullStr, matcher));
    }

    public static int func(String fullStr, String matcher){
        if (matcher.equals("*")){
            return fullStr.length();
        }
        int res = 0;
        boolean isMatch = false;
        for (int i1=0; i1<fullStr.length(); i1++){
            isMatch = true;
            if (i1+matcher.length()>fullStr.length()){
                break;
            }
            if (fullStr.charAt(i1) == matcher.charAt(0) || matcher.charAt(0)=='*'){
                // 如果超出长度
                for (int i2F = i1+1, i2M = 1; i2F<fullStr.length() && i2M<matcher.length(); i2F++, i2M++){
                    if (matcher.charAt(i2M) == '*'){
                        continue;
                    }
                    if (fullStr.charAt(i2F) != matcher.charAt(i2M)){
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch){
                    res++;
                }
            }
        }
        return res;
    }
}
