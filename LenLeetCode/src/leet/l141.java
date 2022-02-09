package leet;

import leet.help.ListNode;

import java.util.HashSet;
import java.util.Set;

public class l141 {
    public static boolean hasCycle(ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int i1=0; ; i1++){
            if (i1!=0) head = head.next;
            if (head==null) break;
            if (set.contains(head.hashCode())) return true;
            set.add(head.hashCode());
        }
        return false;
    }

    public static boolean hasCycle2(ListNode head) {
        // 快慢指针法
        ListNode slow = head;
        ListNode fast = head;
        for (int i1=0; ; i1++){
            fast = fast.next.next;
            slow = slow.next;
            if (fast==null) break;
            if (slow==fast) return true;

        }
        return false;
    }

    public static void main(String[] arg){
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3)));
        hasCycle(listNode);
    }
}
