package leet;

import leet.help.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode in = new ListNode(1, new ListNode(2, new ListNode(3)));
        l237 l = new l237();
        l.deleteNode(in);
        System.out.println(in.toString());

        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(123);
        arrayList1.add(432);
        int[] ints1 = new int[arrayList1.size()];
        for (int i1=0; i1<arrayList1.size(); i1++){
            ints1[i1] = arrayList1.get(i1);
        }
        System.out.println(Arrays.toString(ints1));



        long a = 10l;
        int b = (int) a;
    }
}
