package leet;

import leet.help.ListNode;
import util.LenListNode;

import java.util.ArrayList;
import java.util.Collections;

public class l025 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ArrayList<Integer> inputs = new ArrayList<Integer>();
        for (int i1=0; ; i1++){
            if (i1!=0) head = head.next;
            if (head==null) break;
            inputs.add(head.val);
        }
        // 高级反转
        ArrayList<Integer> results = new ArrayList<Integer>();
        for (int i1=0; i1<inputs.size(); ){
            for (int i2=i1+k-1; i2<inputs.size() & i2>=i1; i2--){
                results.add(inputs.get(i2));
            }
            i1 = i1 + k;
            if (i1+k>inputs.size()){
                for (int i3=i1; i3<inputs.size(); i3++){
                    results.add(inputs.get(i3));
                }
                break;
            }
        }
        Collections.reverse(results);
        // 生成结果ListNode
        ListNode result = null;
        for (int i1=0; i1<results.size(); i1++){
            result = new ListNode(results.get(i1), result);
        }
        return result;
    }

    public static void main(String[] args){
        ListNode inputs = LenListNode.ints2listnode(new int[]{1,2,3,4});
        ListNode result = reverseKGroup(inputs, 2);
    }
    // [1,2,3,4]
    //2
}
