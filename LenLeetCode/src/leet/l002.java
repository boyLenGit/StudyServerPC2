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
        char[] chars_add_1 = string1.toCharArray(); // 将大数String转化为Char数组
        char[] chars_add_2 = string2.toCharArray();
        String string_add_result = ""; // 用于储存最后的大数相加结果
        int index_1 = string1.length()-1; // chars_add_1的索引，用于倒序遍历chars_add_1中的数值
        int index_2 = string2.length()-1; // chars_add_2的索引
        int num_adder_1 = 0; // 抽出的chars_add_1中的末尾数字
        int num_adder_2 = 0; // 抽出的chars_add_2中的末尾数字
        int add_next_level = 0; // 进位判断变量，当=0时不需要进位，当=1时需要进位
        while (true){
            // 抽出最末尾的数字，进行相加
            if(index_1<0){ // 处理chars_add_1遍历完的情况
                num_adder_1 = 0;
            }else {
                num_adder_1 = chars_add_1[index_1] - '0';
            }
            if(index_2<0){
                num_adder_2 = 0;
            }else {
                num_adder_2 = chars_add_2[index_2] - '0';
            }
            int num_adder_result = num_adder_1 + num_adder_2;
            // 若相加的和>=10，需要进位
            if(add_next_level == 1){
                num_adder_result = num_adder_result + 1;
                add_next_level = 0;
            }
            if(num_adder_result>=10){
                add_next_level = 1;
                num_adder_result = num_adder_result - 10;
            }
            string_add_result = string_add_result.concat(String.valueOf(num_adder_result));
            // while循环停止的条件：当两个chars都遍历结束后
            if(index_1<=0 && index_2<=0){
                // 如果遍历结束，还有进位，则进行进位操作，防止出现999+1=0000的结果
                if(add_next_level==1){
                    string_add_result = string_add_result.concat("1");
                }
                break;
            }
            // 索引值每次循环都-1，用于倒序遍历char[]
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


    public static ListNode addTwoNumbers_lc_user(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);   //创建首节点
        ListNode cursor = root;  //声名一个变量用来在移动过程中指向当前节点
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            //获取链表的值
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            //计算和
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;
            //生成新的节点
            ListNode sumNode = new ListNode(sumVal % 10);
            //移动指针指向下一个值
            cursor.next = sumNode;  //把新节点连起来
            cursor = sumNode;  //当前节点往后移动
            if(l1 != null) l1 = l1.next;  //将节点向后移动，对l1的下一个节点进行处理
            if(l2 != null) l2 = l2.next;  //将节点向后移动，对l2的下一个节点进行处理
        }
        return root.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(3, new ListNode(4, null)));
        ListNode l2 = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        ListNode l3 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(1, new ListNode(5, null)))));
        l002.addTwoNumbers_lc_user(l1, l3);
    }
}
