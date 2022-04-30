//package RealMeet.mt0430;
////4 10
////-16 2 -6 8
////5 3
////-1 -1 -1 -1 1 2 3 4
//
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()){
//            String str_in1 = scanner.nextLine();
//            String str_in2 = scanner.nextLine();
//            Solution solution = new Solution();
//            System.out.print(solution.Mi(str_in1, str_in2));
//            System.out.println();
//        }
//    }
//}
//
//
//class Solution{
//    public int Mi(String str1, String str2){
//        ArrayList<Integer> list1 = Help(str1);
//        int m = list1.get(1);
//        int current = 0;
//        int result = 0;
//        int cnt = 0;
//        ArrayList<Integer> list2 = Help(str2);
////        for (int i1=0; i1<list2.size(); i1++){
////            current += (-list2.get(i1));
////            cnt++;
////            if (current>m){
////                current=0;
////                result = Math.max(cnt, result);
////                cnt=0;
////            }
////        }
//        for (int i1=0; i1<list2.size(); i1++){
//            current = 0;
//            cnt = 0;
//            for (int i2=i1; i2<list2.size(); i2++){
//                current += (-list2.get(i2));
//                if (current>m){
//                    break;
//                }
//                cnt++;
//            }
//            result = Math.max(cnt, result);
//            if (cnt+i1>= list2.size()) break;
//        }
//        result = Math.max(cnt, result);
//        return result;
//    }
//
//    public ArrayList<Integer> Help(String str1){
//        String[] in1 = str1.split(" ");
//        ArrayList<Integer> result = new ArrayList<>();
//        for (String item : in1){
//            result.add(Integer.parseInt(item));
//        }
//        return result;
//    }
//}