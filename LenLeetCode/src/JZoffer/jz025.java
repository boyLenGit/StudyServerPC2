package JZoffer;

import leet.help.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class jz025 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ArrayList<Integer> inputs = new ArrayList<>();
        for (int i1=0; ; i1++){
            if (i1!=0) l1 = l1.next;
            if (l1==null)break;
            inputs.add(l1.val);
        }
        for (int i1=0; ; i1++){
            if (i1!=0) l2 = l2.next;
            if (l2==null)break;
            inputs.add(l2.val);
        }
        Collections.sort(inputs);
        ListNode res = null;
        for (int i1=inputs.size()-1; i1>=0; i1--){
            res = new ListNode(inputs.get(i1), res);
        }
        return res;
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // 改用LinkedList
        LinkedList<Integer> inputs = new LinkedList<>();
        for (int i1=0; ; i1++){
            if (i1!=0) l1 = l1.next;
            if (l1==null)break;
            inputs.add(l1.val);
        }
        for (int i1=0; ; i1++){
            if (i1!=0) l2 = l2.next;
            if (l2==null)break;
            inputs.add(l2.val);
        }
        Collections.sort(inputs);
        ListNode res = null;
        for (int i1=inputs.size()-1; i1>=0; i1--){
            res = new ListNode(inputs.get(i1), res);
        }
        return res;
    }

    public static ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        // 认真读了题, 根据"两个递增排序的链表"来做
        if (l2==null) return l1;
        if (l1==null) return l2;
        boolean l1_isUsed = false;
        ListNode temp;
        ListNode l2_mask = l2;
        while (true){
            if (l1_isUsed) {
                l1 = l1.next;
                l1_isUsed = false;
            }
            if (l1==null) break;

            if (l2_mask.val<l1.val){
                if (l2_mask.next!=null && l2_mask.next.val>=l1.val){
                    temp = l2_mask.next;
                    l2_mask.next = new ListNode(l1.val, temp);
                    l1_isUsed = true;
                }else if (l2_mask.next!=null && l2_mask.next.val<l1.val){
                    l2_mask = l2_mask.next;
                }
                else if (l2_mask.next==null){
                    l2_mask.next = new ListNode(l1.val);
                    l1_isUsed = true;
                }
            }else if (l2_mask.val>=l1.val){
                if (l2_mask.next==null){
                    l2_mask.next = new ListNode(l2_mask.val);
                    l2_mask.val = l1.val;
                    l1_isUsed = true;
                }
                l2_mask.next = new ListNode(l1.val, l2_mask.next);
                l1_isUsed = true;
            }
        }
        return l2;
    }

    public static void main(String[] arg){
        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println( mergeTwoLists3(new ListNode(1), new ListNode(2)) );
    }
}
