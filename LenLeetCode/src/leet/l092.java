package leet;

import leet.help.ListNode;

public class l092 {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        int depth = 0;
        ListNode temp = head;
        for (int i1=0; ; i1++){
            if (i1!=0) temp = temp.next;
            if (temp==null) break;
            depth++;
        }
        int[] array = new int[depth];
        int cnt = right-1;
        for (int i1=0; ; i1++){
            if (i1!=0) head = head.next;
            if (head==null) break;
            // 生成数组
            if (i1>=left-1 && i1<=right-1) array[cnt--] = head.val;
            else array[i1] = head.val;
        }
        ListNode res = null;
        for (int i1=array.length-1; i1>=0; i1--){
            res = new ListNode(array[i1], res);
        }
        return res;
    }

    public static void main(String[] ar){
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode1 = new ListNode(1);
        System.out.println(reverseBetween(listNode, 2, 4).toString());
    }
}