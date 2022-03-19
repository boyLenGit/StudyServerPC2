package leet;

import leet.help.ListNode;

import java.util.List;

public class l237 {
    public void deleteNode(ListNode node) {
        ListNode temp = node.next;
        node = temp;
    }

    public static void main(String[] args) {
        ListNode in = new ListNode(1, new ListNode(2, new ListNode(3)));
        l237 l = new l237();
        l.deleteNode(in);
        System.out.println(in.toString());
    }
}
