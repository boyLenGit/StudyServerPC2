package exam.mt0827;

import java.util.*;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/27 16:38
 * 1 2 3 4 5
 * 0 1 2 3 4
 * 5 3
 * 2 3 4
 *
 * 1 2 3 4 5 6 7 8 9 10 11 12
 * 0 1 2 3 4 5 6 7 8 9  10 11
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLineNums = scanner.nextLine().split(" ");
        int[] firstNums = toInts(firstLineNums);
        String[] positionsString = scanner.nextLine().split(" ");
        int[] positions = toInts(positionsString);
        List<Integer> res = func(firstNums[0], firstNums[1], positions);
        for (int i1=0; i1<res.size(); i1++){
            if (i1 != 0){
                System.out.print(" ");
            }
            System.out.print(res.get(i1));
        }
        System.out.println("");
    }

    public static int[] toInts(String[] strings){
        int[] res = new int[strings.length];
        for (int i1=0; i1<strings.length; i1++){
            res[i1] = Integer.parseInt(strings[i1]);
        }
        return res;
    }

    public static List<Integer> func(int len, int times, int[] positions){
        List<Integer> linkedList = new ArrayList<>();
        for (int i1=1; i1<=len; i1++){
            linkedList.add(i1);
        }
        int temp;
        for (int i1=0; i1<positions.length; i1++){
            temp = linkedList.get(positions[i1]-1);
            linkedList.remove(positions[i1]-1);
            linkedList.add(0, temp);
        }
        return linkedList;
    }
}



//