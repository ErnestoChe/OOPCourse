package com.company;

import java.util.LinkedList;

public class BoundedStack<T> {
    private LinkedList<T> stack;
    private int size;
    private int count;

    private int pop_status;
    private int peek_status;
    private int push_status;
    //pop status
    private final int pop_init = 0;
    private final int pop_ok = 1;
    private final int pop_err = 2;
    //peek status
    private final int peek_init = 0;
    private final int peek_ok = 1;
    private final int peek_err = 2;
    //push status
    private final int push_ok = 1;
    private final int push_err = 2;

    BoundedStack(int size){
        pop_status = pop_init;
        peek_status = peek_init;
        stack = new LinkedList<>();
        this.size = size;
        count = 0;
    }
    BoundedStack(){
        pop_status = pop_init;
        peek_status = peek_init;
        stack = new LinkedList<>();
        this.size = 32;
        count = 0;
    }

    public T peek(){
        if(count == 0){
            peek_status = peek_err;
            return null;
        }else{
            peek_status = peek_ok;
            return stack.getLast();
        }
    }

    public T pop(){
        if(count == 0){
            pop_status = pop_err;
            return null;
        }else{
            pop_status = pop_ok;
            count--;
            return stack.remove(count);
        }
    }

    public void push(T elem){
        if(count == size){
            push_status = push_err;
        }else{
            stack.add(elem);
            count++;
            push_status = push_ok;
        }
    }

    public void clear(){
        stack = new LinkedList<>();
        count = 0;
        pop_status = pop_init;
        peek_status = peek_init;
    }

    public int getCount() {
        return count;
    }

    public int getPop_status() {
        return pop_status;
    }

    public int getPeek_status() {
        return peek_status;
    }

    public int getPush_status() {
        return push_status;
    }
}
