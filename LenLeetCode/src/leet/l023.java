package leet;

import leet.help.ListNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class l023 {
    public static ListNode mergeKLists(ListNode[] lists) {
        ArrayList<ArrayList<Integer>> ilist2v = new ArrayList<ArrayList<Integer>>();
        // 提取出链表中的数据
        for (ListNode listNode: lists){
            ArrayList<Integer> ilist1v = new ArrayList<Integer>();
            for (int i1=0; ; i1++){
                if (i1!=0) listNode = listNode.next;
                if (listNode==null) break;
                ilist1v.add(listNode.val);
            }
            ilist2v.add(ilist1v);
        }
        // 所有链表合为一
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i1=0; i1<ilist2v.size(); i1++){
            result.addAll(ilist2v.get(i1));
        }
        Collections.sort(result);
        return new ListNode();
    }

    public static void main(String[] args){
        ListNode input1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode input2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode input3 = new ListNode(2, new ListNode(6));
        ListNode[] listNodes = new ListNode[]{input1, input2,input3};
        ListNode result = mergeKLists(listNodes);
    }
}
