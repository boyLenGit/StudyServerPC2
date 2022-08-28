package exam.jingdong0531;
//5 5
//1 2 3 4 5
//2 3 1 3 3

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String head = scanner.nextLine();
        String[] heads = head.split(" ");
        int n = Integer.parseInt(heads[0]), m = Integer.parseInt(heads[1]);
        String[] bodys = new String[2];
        for (int i1=0; i1<2; i1++){
            bodys[i1] = scanner.nextLine();
        }
        System.out.print(func(n, m, bodys));
    }

    public static int func(int n, int m, String[] bodys){
        String[] str_list0 = bodys[0].split(" ");
        String[] str_list1 = bodys[1].split(" ");
        ArrayList<Integer> list0 = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        boolean[] list_res = new boolean[n];
        for (int i1=0; i1<n; i1++){
            list0.add(Integer.parseInt(str_list0[i1]));
            list1.add(Integer.parseInt(str_list1[i1]));
        }
        for (int i1=1; i1<=n; i1++){
            // 先遍历0
            for (int i2=0; i2<list0.size(); i2++){
                if (list0.get(i2)==i1 && list1.get(i2)!=i1){
                    if(isAlone(list0, list1, list1.get(i2), i1)) {
                        list_res[i1-1] = true;
                        break;
                    }
                }
            }
            // 再遍历1
            for (int i2=0; i2<list1.size(); i2++){
                if (list1.get(i2)==i1 && list0.get(i2)!=i1){
                    if(isAlone(list0, list1, list0.get(i2), i1)) {
                        list_res[i1-1] = true;
                        break;
                    }
                }
            }
        }
        int res = 0;
        for (boolean item: list_res){
            if (item) res++;
        }
        return res;
    }

    public static boolean isAlone(ArrayList<Integer> list0, ArrayList<Integer> list1, int target, int death){
        for (int i1=0; i1<list0.size(); i1++){
            if (list0.get(i1)==target){
                if (list1.get(i1)!=death) return false;
            }
        }
        for (int i1=0; i1<list0.size(); i1++){
            if (list1.get(i1)==target){
                if (list0.get(i1)!=death) return false;
            }
        }
        return true;
    }
}
