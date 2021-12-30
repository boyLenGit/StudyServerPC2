package leet;

import leet.help.ListNode;
import util.LenLog;

public class l002 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String string1 = "";
        String string2 = "";

        while (true){
            string1 = string1.concat(Integer.toString(l1.val));
            if (l1.next==null){
                break;
            }else {
                l1 = l1.next;
            }
        }
        int length1 = string1.length();
        for(int i1=0; i1<length1; i1++){
            
        }
        Long num1 = Long.valueOf(string1);
        LenLog.printString(string1);
        return null;
    }
}
