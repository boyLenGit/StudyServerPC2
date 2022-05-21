package RealMeet.mt0521;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 7
// 1 2 3 4
// 12 13 14 23 24 14
// 123 234
// 1234

public class Main {
    public static void main(String[] args) {
        Solution0521 solution0521 = new Solution0521();
        Scanner scanner = new Scanner(System.in);
        int tree_num = Integer.parseInt(scanner.nextLine());
        String str = scanner.nextLine();
        String[] strings = str.split(" ");
        int[] trees = new int[strings.length];
        System.out.println(solution0521.howMany_multy(trees));
//        System.out.println(solution0521.categorys(2,5));
    }
}

class Solution0521{
    public int howMany(int[] trees){
        int res = trees.length;
        // 树>3  1 3 4 5
        for (int i1=2; i1<trees.length; i1++){
            res += categorys(i1, trees.length);
        }
        return res;
    }

    // 1 2 3 4 5 -> 1 3 5
    public int howMany_multy(int[] trees){
        int res = trees.length + categorys(2, trees.length);
        // 树>3  1 3 4 5
        int length = 3, distance = 1;
        int sub = 0;
        boolean isBreak;
        for (int i1=0; i1+length*distance<=trees.length; i1++){
            isBreak = false;
            int debug1 = i1+length*distance;
            if (i1+length*distance<=trees.length){
                for (int i2=i1+distance; i2<i1+length*distance; i2+=distance){
                    if (i2==i1+distance) sub = trees[i2] - trees[i1];
                    else {
                        if ((trees[i2]-trees[i2+distance])!=sub) {
                            isBreak = true;
                            break;
                        }
                    }
                }
                if (isBreak==false) res++; // 表示符合等差
            }else {
                i1 = 0;
                length++;
            }
        }
        return res;
    }

//    public int numberOfArithmeticSlices(int[] nums) {
//        int ans=0;
//        Map<Long,Integer>[] mapArr=new HashMap[nums.length];
//        for(int i=0;i<nums.length;i++){
//            Map<Long,Integer> map=new HashMap<>();
//            for(int j=0;j<i;j++){
//                long diff=(long)nums[i]-nums[j];
//                map.put(diff,map.getOrDefault(diff,0)+mapArr[j].getOrDefault(diff,0)+1);
//                ans+=mapArr[j].getOrDefault(diff,0);
//            }
//            mapArr[i]=map;
//        }
//        return ans;
//    }

    public int categorys(int n, int m){
        ArrayList<Integer> nums_m = new ArrayList<>();
        ArrayList<Integer> nums_n = new ArrayList<>();
        // n!
//        for (int i1=n; i1<=n; i1++){
//            nums_n.add(i1);
//        }
        // m-n!
        for (int i1=2; i1<=(m-n); i1++){
            nums_n.add(i1);
        }
        // m
        for (int i1=n+1; i1<=m; i1++){
            nums_m.add(i1);
        }
        int res = 1;
        // 除
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
