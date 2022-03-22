package leet;

import java.util.*;

public class l155 {
    public static void main(String[] args) {
        MinStack2 minStack = new MinStack2();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());;   //--> 返回 -3.
        minStack.pop();
        minStack.top();      //--> 返回 0.
        System.out.println(minStack.getMin());;   //--> 返回 -2.
    }

// int num1 = 条件 ? 条件成立赋的值 : 条件不成立赋的值;
}


class MinStack {
    LinkedList<Integer> list = new LinkedList<>();
    int min_val, min_temp;

    public MinStack() {

    }

    public void push(int val) {
        if (list.size()==0) min_val=val;
        else min_val = Math.min(min_val, val);
        list.add(val);
    }

    public void pop() {
        min_temp = list.get(list.size()-1);
        list.remove(list.size()-1);
        if (min_val==min_temp){
            min_val = Integer.MAX_VALUE;
            for (int item: list) min_val = Math.min(item, min_val);
        }
    }

    public int top() {
        return list.get(list.size()-1);
    }

    public int getMin() {
        return min_val;
    }
}


class MinStack2 {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack2() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
