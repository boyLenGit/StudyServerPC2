package leet;

import leet.help.ListNode;

import java.util.ArrayList;

public class l143 {
    public static void reorderList(ListNode head) {
        ArrayList<Integer> inputs = new ArrayList<>();
        for (int i1=0; ;){
            if (i1!=0) head = head.next;
            if (head==null)break;
            inputs.add(head.val);
        }
        ArrayList<Integer> list_res = new ArrayList<>();
        for (int i1=0; i1<(inputs.size()+1)/2; i1++){
            list_res.add(inputs.get(i1));
            list_res.add(inputs.get(inputs.size()-1-i1));
        }
        head = null;
        for (int i1=0; i1<list_res.size(); i1++){
            head = new ListNode(list_res.get(i1), head);
        }
    }

    public static void main(String[] a){
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        reorderList(listNode);
    }
}
