package leet;

import leet.help.ListNode;

public class l141 {
    public static boolean hasCycle(ListNode head) {
        int depth=0;
        for (int i1=0; ; i1++){
            if (i1!=0) head = head.next;
            if (head==null) break;
            System.out.println(head.getClass());
            depth++;
        }
        return true;
    }

    public static void main(String[] arg){
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3)));
        hasCycle(listNode);
    }
}
