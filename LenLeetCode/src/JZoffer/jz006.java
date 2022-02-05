package JZoffer;

import leet.help.ListNode;

import java.util.*;

public class jz006 {
    public static int[] reversePrint(ListNode head) {
        ArrayList<Integer> list_res = new ArrayList<>();
        for (int i1=0; ; i1++){
            if (i1!=0) head = head.next;
            if (head==null)break;
            list_res.add(head.val);
        }
        int[] res = new int[list_res.size()];
        for (int i1=list_res.size()-1, i2=0; i1>=0; i1--, i2++){
            res[i2] = list_res.get(i1);
        }
        return res;
    }

    public static void main(String[] a){
        ListNode listNode = new ListNode(1, new ListNode(3, new ListNode(2)));

        System.out.println(Arrays.toString(reversePrint(new ListNode(3))));
    }
}
