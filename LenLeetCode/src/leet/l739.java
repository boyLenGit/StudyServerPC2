package leet;

import java.util.*;

public class l739 {
    public static int[] dailyTemperatures(int[] temperatures) {
        int pop;
        int[] res = new int[temperatures.length];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i1=0; i1<temperatures.length; i1++){
            while (!stack.isEmpty() && temperatures[i1] > temperatures[stack.peek()]){
                pop = stack.pop();
                res[pop] = i1 - pop;
            }
            stack.addFirst(i1);
        }
        return res;
    }

    public static void main(String[] agr){
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
    }
}
