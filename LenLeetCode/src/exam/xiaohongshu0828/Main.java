package exam.xiaohongshu0828;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/28 16:00
 * 4 3 2
 * 90 90 90
 * 80 100 90
 * 80 85 85
 * 80 100 90
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] line1 = toints(scanner.nextLine().split(" "));
        long[] sums = new long[line1[0]];
        int[] indexs = new int[line1[0]];
        for (int i1=0; i1<line1[0]; i1++){
            sums[i1] = calSum(toints(scanner.nextLine().split(" ")));
            indexs[i1] = i1 + 1;
        }
        long targetSum = sums[line1[2]-1];
        quickSort(sums, indexs, 0, sums.length-1);
//        for (int i1=0; i1<sums.length; i1++){
//            if (indexs[i1] == line1[2]){
//                System.out.println(sums.length-1-i1 + 1);
//            }
//        }
        boolean isInSameErea = false;
        int res = 0;
        List<Integer> sameValItems = new ArrayList<>();
        for (int i1=sums.length-1; i1>=0; i1--){
            if (sums[i1] == targetSum){
                sameValItems.add(indexs[i1]);
                isInSameErea = true;
                continue;
            }
            if (isInSameErea){
                break;
            }
            res++;
        }
        Collections.sort(sameValItems);
        for (int i1=0; i1< sameValItems.size(); i1++){
            res++;
            if (sameValItems.get(i1) == line1[2]){
                break;
            }
        }
        System.out.println(res);
    }

    public static int[] toints(String[] strings){
        int[] res = new int[strings.length];
        for (int i1=0; i1< strings.length; i1++){
            res[i1] = Integer.parseInt(strings[i1]);
        }
        return res;
    }

    public static long calSum(int[] ints){
        long res = 0L;
        for (int item: ints){
            res += item;
        }
        return res;
    }

    public static void quickSort(long[] inputs, int[] inputs1,int start,int end){
        int s, e, compare1, exchange1;
        long compare, exchange;
        if(start>end) return;
        s = start;
        e = end;
        //temp就是基准位
        compare = inputs[start];
        compare1 = inputs1[start];

        while (s<e) {
            //先看右边，依次往左递减
            while (compare<=inputs[e]&&s<e) e--;
            //再看左边，依次往右递增
            while (compare>=inputs[s]&&s<e) s++;
            //如果满足条件则交换
            if (s<e) {
                exchange = inputs[e];
                inputs[e] = inputs[s];
                inputs[s] = exchange;
                exchange1 = inputs1[e];
                inputs1[e] = inputs1[s];
                inputs1[s] = exchange1;
            }
        }
        //最后将基准为与s和e相等位置的数字交换(到这一步,s与e一定相等)
        inputs[start] = inputs[s];
        inputs[s] = compare;
        inputs1[start] = inputs1[s];
        inputs1[s] = compare1;
        //递归调用左半数组
        quickSort(inputs, inputs1, start, e-1);
        //递归调用右半数组
        quickSort(inputs, inputs1, e+1, end);
    }
}
