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

    public static void reorderList2(ListNode head) {
        // 更改算法为:交换
        // 结果: 超时
        ListNode temp_listnode = head;
        int length = 0;
        while (temp_listnode!=null) {
            length++;
            temp_listnode = temp_listnode.next;
        }
        for (int i1=0, index=0; i1<(length+1)/2; i1++, index++){
            dg_move(head, head, -1, 0, (i1+1)*2-1);
        }
        LenLog.printString("1");
    }

    public static int dg_move(ListNode full_listNode, ListNode listNode, int last_value, int index, int positon){
        if (listNode==null){
            dg_replace(full_listNode, last_value, 0, positon);
            return -1;
        }
        if (index>=positon){
            int this_value = listNode.val;
            listNode.val = last_value;
            last_value = dg_move(full_listNode, listNode.next, this_value, index, positon);
        }else {
            index++;
            last_value = dg_move(full_listNode, listNode.next, last_value, index, positon);
        }
        return last_value;
    }

    public static void dg_replace(ListNode listNode, int replace_value, int index, int positon){
        if (listNode==null) return;
        if (index!=positon){
            index++;
            dg_replace(listNode.next, replace_value, index, positon);
            return;
        }
        listNode.val = replace_value;
    }

    public static void main(String[] a){
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode2 = null;
        reorderList2(listNode);
        System.out.println(listNode.toString());
    }
}
// 1234567
// 1726354
// 0123456