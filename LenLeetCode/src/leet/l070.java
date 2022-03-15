package leet;

import java.util.ArrayList;

public class l070 {
    // 题目：爬楼梯
    public static int climbStairs(int n) {
        // 思路：计算每次1、2组合的数组的排列组合数量，累加得到结果
        int result = 0;
        int positions = 0;

        for (int cnt_2=0; cnt_2*2<=n; cnt_2++){
            if (cnt_2==0){
                result++;
                continue;
            }
            positions = n - 2*cnt_2 + cnt_2;
            if (positions==cnt_2){
                result++;
            }else result = result + PaiLieZuHe(cnt_2, positions);
        }
        return result;
    }

    public static int PaiLieZuHe(int m, int n){
        // 生成阶乘的数组，并化简数组内容
        ArrayList<Integer> list_fenzi = new ArrayList<>();
        for (int i1=m+1; i1<=n; i1++){
            list_fenzi.add(i1);
        }
        ArrayList<Integer> list_fenmu = new ArrayList<>();
        for (int i3=2; i3<=n-m; i3++){
            list_fenmu.add(i3);
        }
        //      删除分子与分母的重复项
        for (int i4=0; i4<list_fenzi.size(); i4++){
            if (list_fenmu.contains(list_fenzi.get(i4))){
                list_fenmu.remove(list_fenmu.indexOf(list_fenzi.get(i4)));
                list_fenzi.remove(i4);
                i4--;
            }
        }
        //      单个数组化简，如'[42]与[2]'化简为'[24]与[null]'
        for (int i4=0; i4<list_fenmu.size(); i4++){
            for (int i5=0; i5<list_fenzi.size(); i5++){
                if (list_fenzi.get(i5)%list_fenmu.get(i4)==0){
                    list_fenzi.set(i5, list_fenzi.get(i5)/list_fenmu.get(i4));
                    list_fenmu.remove(i4);
                    i4--;
                    break;
                }
            }
        }
        // 开始计算阶乘
        long result = 1;
        for (Integer value : list_fenzi) {
            result = result * value;
        }
        for (Integer integer : list_fenmu) {
            result = result / integer;
        }
        return (int) result;
    }

    public static long JieCheng(int n){
        long result = 1;
        for (; n>1; n--){
            result = result * n;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(climbStairs(3));
        System.out.println(PaiLieZuHe(1, 4));
    }
}
// 1111111
// 211111
// 121111
// ...
// 111112
// 2211
// 2121
// 2112
// 1221
// 1212
// 1122
