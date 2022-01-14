package leet;

import leet.help.ListNode;

import java.util.ArrayList;

public class l024 {
    public static ListNode swapPairs(ListNode head) {
        ArrayList<Integer> inputs = new ArrayList<Integer>();
        for (int i1=0; ; i1++){
            if (i1!=0) head = head.next;
            inputs.add(head.val);
        }
    }
}
