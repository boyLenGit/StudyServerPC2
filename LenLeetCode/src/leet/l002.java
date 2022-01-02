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
        // 开始合并结果
        //      String实现大数相加算法
        char[] chars_add_1 = string1.toCharArray();
        char[] chars_add_2 = string2.toCharArray();
        String string_add_result = "";
        int index_1 = string1.length()-1;
        int index_2 = string2.length()-1;
        int num_adder_1 = 0;
        int num_adder_2 = 0;
        char[] chars_add_result;
        int add_next_level = 0;
        while (true){
            if(index_1<0){
                num_adder_1 = 0;
            }else {
                num_adder_1 = chars_add_1[index_1] - '0';
            }
            if(index_1<0){
                num_adder_2 = 0;
            }else {
                num_adder_2 = chars_add_2[index_2] - '0';
            }

            int num_adder_result = num_adder_1 + num_adder_2;
            if(add_next_level == 1){
                num_adder_result = num_adder_result + 1;
                add_next_level = 0;
            }
            if(num_adder_result>=10){
                add_next_level = 1;
                num_adder_result = num_adder_result - 10;
            }
            string_add_result = string_add_result.concat(String.valueOf(num_adder_result));
            if(index_1<=0 && index_2<=0){
                break;
            }
            index_1--;
            index_2--;
        }
        char[] chars_result = string_add_result.toCharArray();
        //      反转数组
        String string_result = "";
        for(int i_r=chars_result.length-1; i_r>=0; i_r--){
            string_result = string_result.concat(String.valueOf(chars_result[i_r]));
        }
        chars_result = string_result.toCharArray();
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
