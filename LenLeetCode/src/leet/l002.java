package leet;

import leet.help.ListNode;
import util.LenLog;

import java.math.BigInteger;

public class l002 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String string1 = "";
        String string2 = "";

        // l1
        while (true){
            string1 = string1.concat(Integer.toString(l1.val));
            if (l1.next==null){
                break;
            }else {
                l1 = l1.next;
            }
        }
        char[] chars1 = string1.toCharArray();
        string1 = "";
        for(int i1=chars1.length-1; i1>=0; i1--){
            string1 = string1.concat(String.valueOf(chars1[i1]));
        }
        BigInteger bigInteger1 = BigInteger.valueOf(Long.parseLong(string1));
//        Long num1 = Long.valueOf(string1);

        // l2
        while (true){
            string2 = string2.concat(Integer.toString(l2.val));
            if (l2.next==null){
                break;
            }else {
                l2 = l2.next;
            }
        }
        char[] chars2 = string2.toCharArray();
        string2 = "";
        for(int i2=chars2.length-1; i2>=0; i2--){
            string2 = string2.concat(String.valueOf(chars2[i2]));
        }
        BigInteger bigInteger2 = BigInteger.valueOf(Long.parseLong(string2));
        // 开始合并结果
        BigInteger bigInteger_result = bigInteger1.add(bigInteger2);
        char[] chars_result = String.valueOf(bigInteger_result).toCharArray();
        //      反转数组
//        String string_result = "";
//        for(int i_r=chars_result.length-1; i_r>=0; i_r--){
//            string_result = string_result.concat(String.valueOf(chars_result[i_r]));
//        }
//        chars_result = string_result.toCharArray();
        // result to ListNode
        ListNode listNode_result = new ListNode();
        for(int i4=0; i4<chars_result.length; i4++){
            if(i4 == 0){
                listNode_result = new ListNode((int) (chars_result[i4]-'0'));
                continue;
            }
            listNode_result = new ListNode((int) (chars_result[i4]-'0'), listNode_result);
        }
        return listNode_result;
    }
}
// ListNode l1 = new ListNode(2, new ListNode(3, new ListNode(4, null)));
