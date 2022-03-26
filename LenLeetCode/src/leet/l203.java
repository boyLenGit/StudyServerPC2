package leet;

import leet.help.ListNode;

public class l203 {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode res = head;
        while (head!=null && head.val==val){
            if (head.next!=null){
                head.val = head.next.val;
                head.next = head.next.next;
            }else return null;
        }
        while (head!=null && head.next!=null){
            if (head.next.val==val){
                if (head.next.next!=null){
                    head.next = head.next.next;
                    continue;
                }else head.next=null;
            }
            head = head.next;
        }
//        if (res!=null && res.val==val && res.next==null) return null;
        return res;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(removeElements(listNode1, 1));
    }
}
