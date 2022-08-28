package exam.xiaohongshu0828;

import java.util.*;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/28 16:59
 */
public class Main3C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = Integer.parseInt(scanner.nextLine());
        // zhu

        int[] peoples = toints(scanner.nextLine().split(" "));
        List<int[]> friends = new ArrayList<>();
        for (int i1=0; i1<peoples.length; i1++){
            int[] friend = new int[2];
            friend[0] = peoples[i1];
            friend[1] = i1+1 + 1;
            friends.add(friend);
        }
        // 算法
        Map<Integer, Integer> map = new HashMap<>();
        int righter = 0;
        int res = 0;
        for (int i0=0; i0<friends.size(); i0++){
            int resTemp = 0;
            for (int i1=i0; i1< friends.size(); i1++){
                int[] friend = friends.get(i1);
                if (friend[0]<=righter){
                    continue;
                }
                resTemp ++;
                righter = friend[1];
            }
            res = Math.max(res, resTemp);
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
}
