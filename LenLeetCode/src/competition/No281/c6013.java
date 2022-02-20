package competition.No281;

import leet.help.ListNode;
import leet.help.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class c6013 {
    public ListNode mergeNodes(ListNode head) {
        int sum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i1=0; ; i1++){
            if (i1!=0) head = head.next;
            if (head==null) break;
            if (head.val==0 && sum!=0) {
                list.add(sum);
                sum=0;
            }else sum+=head.val;
        }
        ListNode ret = null;
        for (int i1=list.size()-1; i1>=0; i1--){
            ret = new ListNode(list.get(i1), ret);
        }
        return ret;
    }

    public static void main(String[] arg){
        ListNode input1 = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(0)))));
        c6013 a = new c6013();
        System.out.println(a.mergeNodes(input1));
    }
}
