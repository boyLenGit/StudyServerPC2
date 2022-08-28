//package RealMeet.mt0430;
//
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()){
//            String str_in1 = scanner.next();
//            String str_in2 = scanner.next();
//            Solution solution = new Solution();
//            System.out.print(solution.HM(str_in1, str_in2));
//            System.out.println();
//        }
//    }
//}
//
//
//class Solution{
//    public int HM(String str1, String str2){
//        int result = 0;
//        String s_temp2;
//        for (int i2=0; i2+str1.length()<=str2.length(); i2++){
//            s_temp2 = i2+str1.length()<str2.length() ? str2.substring(i2, i2+str1.length()) : str2.substring(i2);
//            result += distance(str1, s_temp2);
//        }
//        return result;
//    }
//
//    public int distance(String str1, String str2){
//        int result = 0;
//        for (int i1=0; i1<str1.length() & i1< str2.length(); i1++){
//            result += Math.abs((str1.charAt(i1)-'0') - (str2.charAt(i1)-'0'));
//        }
//        return result;
//    }
//}