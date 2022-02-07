package JZoffer;

import leet.help.ListNode;

import java.util.LinkedList;
import java.util.Stack;

public class jz030 {
    public static void main(String[] arg){
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
    }

}

class MinStack2 {
    Stack<Integer> stack;
    Stack<Integer> mins;

    /** initialize your data structure here. */
    public MinStack2() {
        stack = new Stack<>();
        mins = new Stack<>();
    }

    public void push(int x) {
        stack.add(x);
        if (mins.isEmpty() || mins.peek()>=x) mins.add(x);
    }

    public void pop() {
        if (stack.pop().equals(mins.peek())) mins.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return mins.peek();
    }
}

class Node{
    int val;
    Node next;
    public Node() {}
    public Node(int val) { this.val = val; }
    public Node(int val, Node next) { this.val = val; this.next = next; }
}

class MinStack {
    Node stack;
    Node mins;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Node();
        mins = new Node();
    }

    public void push(int x) {
        if (stack.next==null) stack.val=x;
        else stack = new Node(x,stack);

        if (mins.next==null || mins.val>=x){
            if (mins.next==null) mins.val=x;
            else if (mins.val>=x) mins = new Node(x, mins);
        }
    }

    public void pop() {
        if (stack.val==mins.val) mins = mins.next;
        stack = stack.next;
    }

    public int top() {
        return stack.val;
    }

    public int min() {
        return mins.val;
    }
}