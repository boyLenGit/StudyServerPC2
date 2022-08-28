package exam.mt0820Mo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 第几题
 */
public class Main {
    public static int[] transform(String[] strings) {
        int[] res = new int[strings.length];
        for (int i1 = 0; i1 < strings.length; i1++) {
            res[i1] = Integer.parseInt(strings[i1]);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 拿第1行两个数
        String line1 = scanner.nextLine();
        String[] strs1 = line1.split(" ");
        int[] nums1 = transform(strs1);
        // 拿第2行n个数
        String line2 = scanner.nextLine();
        String[] strs2 = line2.split(" ");
        int[] nums2 = transform(strs2);
        // 拿第3行n个数
        String line3 = scanner.nextLine();
        String[] strs3 = line3.split(" ");
        int[] nums3 = transform(strs3);
        // 计算并打印结果
        func1(nums1[1], nums2, nums3);
    }

    public static void func1(int max, int[] probable, int[] results) {
        // 求(1-概率) * 分数
        int[] distance = new int[results.length];
        for (int i1 = 0; i1 < results.length; i1++) {
            distance[i1] = (100 - probable[i1]) * results[i1];
        }
        // 排序取最大的
        Arrays.sort(distance);
        // 求结果
        long res = 0L;
        for (int i1 = 0; i1 < results.length; i1++) {
            res += (long) results[i1] * probable[i1];
        }
        for (int i1 = 0; i1 < max; i1++) {
            res += distance[distance.length - 1 - i1];
        }
        // 输出
        double doubleRes = ((double) res) / 100;
        System.out.printf("%.2f%n", doubleRes);
    }


}







