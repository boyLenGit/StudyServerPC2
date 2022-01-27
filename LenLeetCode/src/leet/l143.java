package leet;

import leet.help.ListNode;
import util.LenLog;

import java.util.ArrayList;

public class l143 {
    public static void reorderList(ListNode head) {
        ArrayList<Integer> inputs = new ArrayList<>();
        ListNode temp_listNode = head;
        for (int i1=0; ;i1++){
            if (i1!=0) temp_listNode = temp_listNode.next;
            if (temp_listNode==null)break;
            inputs.add(temp_listNode.val);
        }
        ArrayList<Integer> list_res = new ArrayList<>();
        for (int i1=0; i1<(inputs.size()+1)/2; i1++){
            list_res.add(inputs.get(i1));
            list_res.add(inputs.get(inputs.size()-1-i1));
        }
        dg(head, list_res);
    }

    public static void dg(ListNode listNode, ArrayList<Integer> vals){
        if (listNode==null || vals.size()==0) return;
        listNode.val = vals.get(0);
        vals.remove(0);
        dg(listNode.next, vals);
    }

    public static void main(String[] a){
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        reorderList(listNode);
        System.out.println(listNode.toString());
    }
}
