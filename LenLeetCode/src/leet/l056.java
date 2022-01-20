package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// 合并区间
public class l056 {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        ArrayList<int[]> list_res = new ArrayList<>();
        int temp_0, temp_1;
        list_res.add(intervals[0]);
        for (int i1=1, list_i1=0; i1<intervals.length; i1++, list_i1++){
            if (list_res.get(list_i1)[1]>=intervals[i1][0]){
                temp_0 = list_res.get(list_i1)[0];
                temp_1 = list_res.get(list_i1)[1];
                list_res.remove(list_i1);
                list_res.add(new int[]{Math.min(temp_0, intervals[i1][0]), Math.max(intervals[i1][1], temp_1)});
                list_i1--;
            }else list_res.add(intervals[i1]);
        }
        int[][] result = new int[list_res.size()][];
        for (int i1=0; i1<list_res.size(); i1++){
            result[i1] = list_res.get(i1);
        }
        return result;
    }

    public static int[][] merge2(int[][] intervals) {
        // 优化方法一，去掉ArrayList，加快速度降低内存
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        int cnt = 1;
        for (int i1=1, i_res=1; i1<intervals.length; i1++){
            if (intervals[i_res-1][1]>=intervals[i1][0]){
                intervals[i_res-1][0] = Math.min(intervals[i_res-1][0], intervals[i1][0]);
                intervals[i_res-1][1] = Math.max(intervals[i_res-1][1], intervals[i1][1]);
            }else {
                intervals[i_res][0] = intervals[i1][0];
                intervals[i_res][1] = intervals[i1][1];
                i_res++;
            }
            cnt = i_res;
        }
        return Arrays.copyOf(intervals, cnt);
    }

    public static void main(String[] a){
        int[][] inputs = new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}};
        int[][] res = merge2(inputs);
        System.out.println(Arrays.deepToString(res));
    }
}
// {{1,4},{0,4}}
// {{1,3},{2,6},{8,10},{15,18}}
// {{1,4},{0,2},{3,5}}
// {{2,3},{4,5},{6,7},{8,9},{1,10}}