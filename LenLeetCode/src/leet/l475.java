package leet;

import java.util.Arrays;

public class l475 {
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int res = 0;
        int distance = 0;
        for (int i1=0; i1<houses.length; i1++){
            distance = Math.abs(houses[i1]-heaters[0]);
            for (int i2=1; i2<heaters.length; i2++){
                if (Math.abs(houses[i1]-heaters[i2])>distance) break;
                distance = Math.abs(houses[i1]-heaters[i2]);
            }
            res = Math.max(res, distance);
        }
        return res;
    }

    public static int findRadius2(int[] houses, int[] heaters) {
        // 消除排序,优化速度
        // 效果:更慢了, 应该是因为由于没有排序,第二个for循环耗时更多了
        Arrays.sort(heaters);
        int res = 0;
        int distance = 0;
        for (int i1=0; i1<houses.length; i1++){
            distance = Math.abs(houses[i1]-heaters[0]);
            for (int i2=1; i2<heaters.length; i2++){
                distance = Math.min(Math.abs(houses[i1]-heaters[i2]), distance);
            }
            res = Math.max(res, distance);
        }
        return res;
    }

    public static int findRadius3(int[] houses, int[] heaters) {
        // 消除排序,优化速度
        // 效果:加了个排序时间更短了, 推测是因为排序后, house是从小到大, 因此遍历heater时更快到达跳出循环的部分
        Arrays.sort(heaters);
        int res = 0;
        int distance = 0;
        for (int i1=0; i1<houses.length; i1++){
            distance = Math.abs(houses[i1]-heaters[0]);
            for (int i2=1; i2<heaters.length; i2++){
                distance = Math.min(Math.abs(houses[i1]-heaters[i2]), distance);
            }
            res = Math.max(res, distance);
        }
        return res;
    }

    public static void main(String[] a){
        int[] input1 = new int[]{282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923};
        int[] input2 = new int[]{823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612};
        System.out.println(findRadius(input1, input2));
    }
}
//[282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923]
//[823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612]