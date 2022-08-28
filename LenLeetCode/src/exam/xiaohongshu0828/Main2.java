package exam.xiaohongshu0828;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/28 16:51
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] line1 = toints(scanner.nextLine().split(" "));
        int[] nums = toints(scanner.nextLine().split(" "));
        System.out.println(func(nums, line1[0], line1[1]));
    }

    public static int func(int[] nums, int n, int K) {
        Arrays.sort(nums);
        int res = 0;
        for (int i1 = 0; i1 < n; i1++) {
            for (int i2 = i1 + 1; i2 < n; i2++) {
                if (nums[i1] * nums[i2] >= K) {
                    res += (n - i2);
                    break;
                }
            }
        }
        return res * 2;
    }

    public static int[] toints(String[] strings) {
        int[] res = new int[strings.length];
        for (int i1 = 0; i1 < strings.length; i1++) {
            res[i1] = Integer.parseInt(strings[i1]);
        }
        return res;
    }
}
