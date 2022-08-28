package exam.mt0521;

import java.util.ArrayList;
import java.util.Scanner;

// 7
// 1 2 3 4
// 12 13 14 23 24 14
// 123 234
// 1234

// 123
// 1 2 3
// 12 23 13
// 123

// 12345
// 1 2 3 4 5  x5
// 12 13 14 15 23 24 25 34 35 45  x10
// 123 234 345 135 x4
// 1234 2345
// 12345

public class Main {
    public static void main(String[] args) {
        Solution0521 solution0521 = new Solution0521();
        Scanner scanner = new Scanner(System.in);
        int tree_num = Integer.parseInt(scanner.nextLine());
        String str = scanner.nextLine();
        String[] strings = str.split(" ");

        if (strings.length==1) System.out.println(1);
        else {
            int[] trees = new int[strings.length];
            for (int i1=0; i1<strings.length; i1++){
                trees[i1] = Integer.parseInt(strings[i1]);
            }
            System.out.println(solution0521.howMany(trees));
        }
    }
}

class Solution0521{
    public int howMany(int[] trees){
        int res = trees.length + categorys(2, trees.length);
        int length = 3;
        int sub = 0;
        boolean isBreak;
        for (int distance=1; length*distance<=trees.length; distance++){
            for (int i1=0; i1+length*distance<=trees.length; i1++){
                isBreak = false;
                if (i1+length*distance<=trees.length){
                    for (int i2=i1+distance; i2<i1+length*distance; i2+=distance){
                        if (i2==i1+distance) {
                            sub = trees[i2] - trees[i1];
                        }
                        else {
                            if ((trees[i2]-trees[i2-distance])!=sub) {
                                isBreak = true;
                                break;
                            }
                        }
                    }
                    if (!isBreak) res++; // 表示符合等差
                }
                if (i1+length*distance + 1 > trees.length){
                    i1 = -1;
                    length++;
                }
            }
        }
        return res;
    }

    // 求排列组合: C{n, m}
    public int categorys(int n, int m){
        ArrayList<Integer> nums_m = new ArrayList<>();
        ArrayList<Integer> nums_n = new ArrayList<>();
        // m-n!
        for (int i1=2; i1<=(m-n); i1++){
            nums_n.add(i1);
        }
        // m
        for (int i1=n+1; i1<=m; i1++){
            nums_m.add(i1);
        }
        int res = 1;
        // 阶乘求C{n, m}
        int i_n = 0;
        for (int i_m=0; i_m<nums_m.size();i_m++){
            res *= nums_m.get(i_m);
            if (i_n<nums_n.size() && res % nums_n.get(i_n)==0){
                res = res/nums_n.get(i_n);
                i_n++;
            }
        }
        for (; i_n<nums_n.size(); i_n++){
            res = res / nums_n.get(i_n);
        }
        return res;
    }
}
