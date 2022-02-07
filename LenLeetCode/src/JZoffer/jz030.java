package JZoffer;

import java.util.LinkedList;
import java.util.Stack;

public class jz030 {

}

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> mins;

    /** initialize your data structure here. */
    public MinStack() {
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