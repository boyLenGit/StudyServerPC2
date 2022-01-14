package leet;

import leet.help.ListNode;

import java.util.ArrayList;

public class l024 {
    public static ListNode swapPairs(ListNode head) {
        ArrayList<Integer> inputs = new ArrayList<Integer>();
        for (int i1=0; ; i1++){
            if (i1!=0) head = head.next;
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
        // 
    }
}
// 12345
// 21435
