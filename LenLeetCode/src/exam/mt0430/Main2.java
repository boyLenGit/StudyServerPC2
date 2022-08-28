package exam.mt0430;
//1
//3
//-1 -1 -1
//0 0 1


import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] result;
        while (scanner.hasNext()){
            int int1 = Integer.parseInt(scanner.nextLine());
            result = new String[int1];
            for (int i1=0; i1<int1; i1++){
                int int2 = Integer.parseInt(scanner.nextLine());
                String str1 = scanner.nextLine();
                Solution solution = new Solution();
                result[i1] = solution.fucn(int2, str1);
            }
            // 输出
            for (int i1=0; i1<int1; i1++){
                System.out.println(result[i1]);
            }
        }
    }
}


class Solution{
    public String fucn(int int1, String str1){
        ArrayList<Integer> list1 = Help(str1);
        int cnt = 0;
        boolean hasPositive = false;
        for (int i1=0; i1<list1.size(); i1++){
            if (list1.get(i1)<=0) hasPositive = true;
            else cnt++;
            if (hasPositive && cnt>0) return "Yes";
        }
        if (cnt==0) return "Yes"; // 一个正数都没有
        return (cnt>0 && hasPositive) ? "Yes" : "No";
    }

    public ArrayList<Integer> Help(String str1){
        String[] in1 = str1.split(" ");
        ArrayList<Integer> result = new ArrayList<>();
        for (String item : in1){
            result.add(Integer.parseInt(item));
        }
        return result;
    }
}