package leet;

import leet.help.ListNode;

import java.util.List;

public class l237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode in = new ListNode(1, new ListNode(2, new ListNode(3)));
        l237 l = new l237();
        l.deleteNode(in);
        System.out.println(in.toString());
    }
}
