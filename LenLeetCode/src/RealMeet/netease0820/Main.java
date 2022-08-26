package RealMeet.netease0820;

import java.util.Scanner;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/20 15:16
 * 6
 * 1 1 4 5 1 4
 * 0 1 2 3 4 5
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        String[] strings = scanner.nextLine().split(" ");
        int[] nums = new int[strings.length];
        for (int i1=0; i1<strings.length; i1++){
            nums[i1] = Integer.parseInt(strings[i1]);
        }

    }

    public static void func(int[] nums){

    }
}
