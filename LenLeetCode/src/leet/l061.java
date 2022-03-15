package leet;

import leet.help.ListNode;

public class l061 {
    public static ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head;
        int depth = 0;
        for (int i1=0;; i1++){
            if (i1!=0) temp = temp.next;
            if (temp==null)break;
            depth++;
        }
        int[] res = new int[depth];
        temp = head;
        int cnt = k;
        for (int i1=0;; i1++){
            if (i1!=0) temp = temp.next;
            if (temp==null)break;
            res[cnt++] = temp.val;
        }
        temp = head;
        for (int i1=0; i1<k; i1++){
            if (i1!=0) temp = temp.next;
            if (temp==null)break;
            res[i1] = temp.val;
        }
        return temp;
    }

    public static ListNode rotateRight2(ListNode head, int k) {
        if (head==null) return head;
        ListNode temp = head;
        ListNode ret = new ListNode();
        int depth = 0;
        for (int i1=0;; i1++){
            if (i1!=0) temp = temp.next;
            if (temp==null)break;
            depth++;
        }
        k = k%depth; // while (k>=depth & k!=0) k -= depth; 的效率直接大打折扣
        if (k==0) return head;

        temp = head;
        for (int i1=0;; i1++){
            if (i1!=0) temp = temp.next;
            if (temp==null)break;
            if (i1==(depth-k)-1){
                ret = temp.next;
                temp.next = null;
                break;
            }
        }
        temp = ret;
        for (int i1=0;;i1++){
            if (i1!=0) temp = temp.next;
            if (i1==k-1) {
                temp.next = head;
                break;
            }
        }
        return ret;
    }

    public static void main(String[] arg){
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        rotateRight2(listNode, 1);
    }
}
