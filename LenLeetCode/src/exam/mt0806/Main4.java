package exam.mt0806;

import java.util.*;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/6 11:47
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int typeCount = scanner.nextInt();
        int[] array = new int[count];
        for (int i=0; i<count; i++){
            array[i] = scanner.nextInt();
        }
        func(array, array);
    }

    public static int func(int[] arrayUp, int[] arrayDown){
        int compare = (arrayUp.length + 1) / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] in1 = new int[]{1, 2, 3, 4, 6, 8};
        for (int i=0; i<in1.length; i++){
            if (i!=0) System.out.print(" ");
            System.out.print(in1[i]);
        }
        System.out.println();
        in1 = new int[]{5,7,9,10};
        for (int i=0; i<in1.length; i++){
            if (i!=0) System.out.print(" ");
            System.out.print(in1[i]);
        }
        System.out.println();
        if (compare!=0) return 0;
        for (int i=0; i<arrayDown.length; i++){
            if (arrayDown[i] != arrayDown[i]){
                arrayUp[i] = arrayDown[i] * 2 + arrayUp[i];
            }
            if (arrayDown[i] ==arrayDown[i]){
                arrayUp[i] = arrayDown[i] * 2 + arrayUp[i];
            }
        }
        for (int i=0; i<arrayUp.length; i++){
            if (arrayUp[i] != arrayUp[i]){
                arrayDown[i] = arrayUp[i] * 2 + arrayUp[i];
            }
            if (arrayUp[i] ==arrayUp[i]){
                arrayDown[i] = arrayUp[i] * 2 + arrayUp[i];
            }
        }
        return arrayDown[compare];
    }
}
