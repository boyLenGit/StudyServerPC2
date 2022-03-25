package leet;

import leet.help.ListNode;

import java.util.HashMap;

public class l083 {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode shadow = head;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(shadow.val, 0);
        while (shadow.next!=null){
            if (map.containsKey(shadow.next.val)){
                if (shadow.next.next==null) shadow.next=null;
                else {
                    shadow.next = shadow.next.next;
                    continue;
                }
            }else map.put(shadow.next.val, 0);
            shadow = shadow.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode in1 = new ListNode(1, new ListNode(2, new ListNode(1)));
        System.out.println(deleteDuplicates(in1));
    }
}
