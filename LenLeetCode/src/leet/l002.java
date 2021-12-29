package leet;

import leet.help.ListNode;

public class l002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String string1 = "";
        String string2 = "";
        while (true){
            string1 = string1.concat(Integer.toString(l1.val));
            if (l1.next==null){
                break;
            }
        }
        Long num1 = Long.valueOf(string1);
    }
}
