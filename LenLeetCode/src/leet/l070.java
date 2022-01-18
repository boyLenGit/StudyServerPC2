package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class l070 {
    public static int climbStairs(int n) {
        ArrayList<String> list_result = new ArrayList<>();
        ArrayList<String> list_result_temp = new ArrayList<>();
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
            }else {
                long fenzi = JieCheng(positions);
                long fenmu = (JieCheng(cnt_2)*JieCheng(positions-cnt_2));
                result = result + (int)(fenzi/fenmu);
                result = result + PaiLieZuHe(cnt_2, positions);
            }
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
        for (int i3=1; i3<=n-m; i3++){
            list_fenmu.add(i3);
        }
        //      删除分子与分母的重复项
        for (int i4=0; i4<list_fenzi.size(); i4++){
            if (list_fenmu.contains(list_fenzi.get(i4))){
                list_fenmu.remove(list_fenmu.indexOf(list_fenmu.get(i4)));
                list_fenzi.remove(i4);
                i4--;
            }
        }
        // 开始计算阶乘
        long result = 1;
        for (int i5=0; i5<list_fenzi.size(); i5++){
            result = result * list_fenzi.get(i5);
        }
        for (int i6=0; i6<list_fenmu.size(); i6++){
            result = result / list_fenmu.get(i6);
        }
        return (int) result;
    }

    public static long JieCheng(int n){
        long result = 1;
        for (; n>1; n--){
            result = result * n;
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args){
//        System.out.println(climbStairs(14));
        System.out.println(PaiLieZuHe(2, 4));
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
