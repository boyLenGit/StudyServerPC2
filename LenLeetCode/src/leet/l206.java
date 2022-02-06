package leet;

import leet.help.ListNode;

public class l206 {
    public static ListNode reverseList(ListNode head) {
        ListNode res = null;
        for (int i1=0; ; i1++){
            if (i1!=0){
                res = new ListNode(head.val, res);
                head = head.next;
            }
            if (head==null)break;
        }
        return res;
    }

    public static ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    public static void main(String[] ar){
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(reverseList2(listNode).toString());
    }
}
