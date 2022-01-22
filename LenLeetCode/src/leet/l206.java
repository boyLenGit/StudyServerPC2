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
}
