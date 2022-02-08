package JZoffer;

import leet.help.ListNode;

import java.util.ArrayList;
import java.util.Collections;

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

    public static void main(String[] arg){
        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println(mergeTwoLists(null, new ListNode(1)));
    }
}
