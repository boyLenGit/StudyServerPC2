package leet;

import leet.help.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class l234 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> arrayList = new LinkedList<>();
        for (int i1=0; ; i1++){
            if (i1!=0) head = head.next;
            if (head==null) break;
            arrayList.add(head.val);
        }
        for (int i1=0, i2=arrayList.size()-1; i1<i2; i1++, i2--){
            if (arrayList.get(i1).intValue()!=arrayList.get(i2).intValue()) return false;
        }
        return true;
    }

    public static boolean isPalindrome2(ListNode head) {
        int length=0;
        ListNode node = null;
        ListNode shadow = head;
        for (int i1=0; ; i1++){
            if (i1!=0) shadow = shadow.next;
            if (shadow==null) {
                length = i1+1;
                break;
            }
            node = new ListNode(shadow.val, node);
        }
        for (int i1=0; i1<length/2; i1++){
            if (i1!=0){
                head = head.next;
                node = node.next;
            }
            if (node.val!=head.val) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode in1 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.println(isPalindrome2(in1));
    }
}
