package leet;

import leet.help.ListNode;

import java.util.HashMap;

public class l160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode, Integer> map = new HashMap<>();
        for (int i1=0; ; i1++){
            if (i1!=0) headA = headA.next;
            if (headA==null)break;
            map.put(headA, 1);
        }
        for (int i1=0; ; i1++){
            if (i1!=0) headB = headB.next;
            if (headB==null) break;
            if (map.containsKey(headB)) return headB;
        }
        return null;
    }
}
