package leet;

import java.util.ArrayList;

// 合并区间
public class l056 {
    public static int[][] merge(int[][] intervals) {
        ArrayList<int[]> list_res = new ArrayList<>();
        int temp = 0;
        list_res.add(intervals[0]);
        for (int i1=1, list_i1=0; i1<intervals.length; i1++, list_i1++){
            if (list_res.get(list_i1)[1]>=intervals[i1][0]){
                temp = list_res.get(list_i1)[0];
                list_res.remove(list_i1);
                list_res.add(new int[]{temp, intervals[i1][1]});
                list_i1--;
            }else list_res.add(intervals[i1]);
        }
        int[][] result = new int[list_res.size()][];
        for (int i1=0; i1<list_res.size(); i1++){
            result[i1] = list_res.get(i1);
        }
        return result;
    }

    public static void main(String[] a){
        int[][] inputs = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        merge(inputs);
    }
}
