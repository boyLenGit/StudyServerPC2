package JZoffer;

import leet.help.ListNode;

public class jz024 {
    public static ListNode reverseList(ListNode head) {
        ListNode res = null;
        for (int i1=0; ; i1++){
            if (i1!=0) {
                res = new ListNode(head.val, res);
                head = head.next;
            }
            if (head==null) break;
        }
        return res;
    }

    public static void main(String[] a){
        ListNode inputs = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        reverseList(null);
    }

}
