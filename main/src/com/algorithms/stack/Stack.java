package com.algorithms.stack;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
    private List<T> stack;
    private int top;
    public Stack(){
        top = -1;
        stack = new ArrayList<>();
    }

    public void push(T t){
        stack.add(t);
        top++;
    }

    public T pop() throws Exception {
        if(top==-1)
            throw new Exception("Stack Underflow Exception");
        T t = stack.remove(top);
        top--;
        return t;
    }

    public T peek() throws Exception {
        if(top==-1)
            throw new Exception("Stack Underflow Exception");
        return stack.get(top);
    }

    public boolean empty() {
        return top==-1;
    }
}
