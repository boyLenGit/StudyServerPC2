package leet;

import leet.help.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class l019 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<Integer> inputs = new ArrayList<Integer>();
        ListNode input_temp = head;
        for (int i1=0; ; i1++){
            if (i1==0){
                inputs.add(head.val);
                if (head.next==null) break;
                input_temp = head.next;
                continue;
            }
            inputs.add(input_temp.val);
            if (input_temp.next==null)break;
            input_temp = input_temp.next;
        }
        inputs.remove(inputs.size()-n);
        Collections.reverse(inputs);
        ListNode result = null;
        for (int i1=0; i1<inputs.size(); i1++){
            if (i1==0) {
                 result = new ListNode(inputs.get(i1));
            }
            if (i1+1>=inputs.size()) break;
            result = new ListNode(inputs.get(i1+1), result);
        }
        return result;
    }

    public static void main(String[] args){
        ListNode input = new ListNode(
                1, new ListNode(
                        2, new ListNode(
                                3, new ListNode(
                                        4, new ListNode(
                                                5
        )
        )
        )
        )
        );
        ListNode result = removeNthFromEnd(input, 2);
        System.out.println(result);
    }
}
