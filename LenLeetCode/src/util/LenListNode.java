package util;

import leet.help.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LenListNode {
    public static ListNode list2listnode(List<Integer> inputs){
        Collections.reverse(inputs);
        ListNode result = null;
        for (Integer input : inputs) {
            result = new ListNode(input, result);
        }
        return result;
    }

    public static ListNode ints2listnode(int[] inputs){
        ArrayList<Integer> ALinput= new ArrayList<Integer>();
        for (Integer item: inputs){
            ALinput.add(item);
        }
        Collections.reverse(ALinput);
        ListNode result = null;
        for (Integer input : ALinput) {
            result = new ListNode(input, result);
        }
        return result;
    }
}
