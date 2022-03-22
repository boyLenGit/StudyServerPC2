package leet;

import java.util.LinkedList;

public class l225 {

}


class MyStack {
    private LinkedList<Integer> list = new LinkedList<>();
    int poped;

    public MyStack() {

    }

    public void push(int x) {
        list.add(x);
    }

    public int pop() {
        poped = list.get(list.size()-1);
        list.remove(list.size()-1);
        return poped;
    }

    public int top() {
        poped = list.get(list.size()-1);
        return poped;
    }

    public boolean empty() {
        return list.size()==0;
    }
}