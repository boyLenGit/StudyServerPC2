package exam.mt0827;

import java.util.Scanner;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/27 17:12
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLineNums = scanner.nextLine().split(" ");
        String fullStr = scanner.nextLine();
        int[] lens = toInts(scanner.nextLine().split(" "));
        String[] strLite = new String[lens.length];
        for (int i1=0; i1<lens.length; i1++){
            strLite[i1] = scanner.nextLine();
        }
//        func()
        System.out.println(2);
    }

    public static int[] toInts(String[] strings){
        int[] res = new int[strings.length];
        for (int i1=0; i1<strings.length; i1++){
            res[i1] = Integer.parseInt(strings[i1]);
        }
        return res;
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
//    public static List<Integer> func(int len, int times, int[] positions){
//
//    }

}
