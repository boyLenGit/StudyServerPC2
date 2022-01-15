package leet;

import leet.help.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class l024 {
    public static ListNode swapPairs(ListNode head) {
        ArrayList<Integer> inputs = new ArrayList<Integer>();
        for (int i1=0; ; i1++){
            if (i1!=0) head = head.next;
            if (head==null) break;
            inputs.add(head.val);
        }
        // 开始交换
        ArrayList<Integer> result_list = new ArrayList<Integer>();
        for (int i1=0; i1<inputs.size(); i1=i1+2){
            if (i1+1<inputs.size()){
                result_list.add(inputs.get(i1+1));
                result_list.add(inputs.get(i1));
                continue;
            }
            result_list.add(inputs.get(i1));
        }
        // 生成ListNode
        Collections.reverse(result_list);
        ListNode result = null;
        for (int i1=0; i1<result_list.size(); i1++){
            result = new ListNode(result_list.get(i1), result);
        }
        return result;
    }


    public static void main(String[] args){
        ListNode input1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode()))));
        ListNode result = swapPairs(input1);
    }
}
// 12345
// 21435
