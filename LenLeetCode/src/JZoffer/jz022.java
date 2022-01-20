package JZoffer;

import com.sun.org.apache.bcel.internal.generic.LNEG;
import leet.help.ListNode;

import java.util.ArrayList;

public class jz022 {
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode result = null;
        ArrayList<ListNode> nodes = new ArrayList<>();
        ArrayList<Integer> list_in = new ArrayList<>();
        for (int i1=0; ; i1++){
            if (i1!=0) head = head.next;
            if (head==null) break;
            nodes.add(head);
        }
        return nodes.get(nodes.size()-k);
    }

    public static void main(String[] s){
        ListNode inputs = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode())))));
        ListNode result = getKthFromEnd(inputs, 2);
        System.out.println(result.toString());
    }
}
