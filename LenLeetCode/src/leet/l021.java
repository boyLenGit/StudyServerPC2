package leet;

import leet.help.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class l021 {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ArrayList<Integer> alist1 = new ArrayList<Integer>();
        do {
            alist1.add(list1.val);
            list1 = list1.next;
        } while (list1 != null);

        do {
            alist1.add(list2.val);
            list2 = list2.next;
        } while (list2 != null);
        Collections.sort(alist1);
        ListNode result = new ListNode();
        for (int i1=0; i1<alist1.size(); i1++){
            if (i1==0){
                result.val = alist1.get(i1);
                continue;
            }
            result = new ListNode(alist1.get(i1), result);
        }
        return result;
    }

    public static void main(String[] args){
        ListNode input1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode input2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode result = mergeTwoLists(input1, input2);
    }
}
