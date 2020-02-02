package com.company;

import java.util.LinkedList;

public class BoundedStack<T> {
    //скрытые поля
    private LinkedList<T> stack;    //хранилище стека
    private int size;               //размер стека
    private int count;              //количество элементов

    private int pop_status;         //статус команды pop()
    private int peek_status;        //статус команды peek()
    private int push_status;        //статус команды push()
    //pop status
    private final int pop_init = 0;
    private final int pop_ok = 1;
    private final int pop_err = 2;
    //peek status
    private final int peek_init = 0;
    private final int peek_ok = 1;
    private final int peek_err = 2;
    //push status
    private final int push_init = 0;
    private final int push_ok = 1;
    private final int push_err = 2;

    BoundedStack(int size){  //конструктор с размером
        //начальные статусы
        pop_status = pop_init;
        peek_status = peek_init;
        push_status = push_init;

        stack = new LinkedList<>();
        this.size = size;
        count = 0;
    }
    BoundedStack(){         //стандартный конструктор
        //начальные статусы
        pop_status = pop_init;
        peek_status = peek_init;
        push_status = push_init;
        stack = new LinkedList<>();
        this.size = 32;
        count = 0;
    }

    public T peek(){        //возвращает верхний элемент из стека без удаления
        if(count == 0){
            peek_status = peek_err;
            return null;
        }else{
            peek_status = peek_ok;
            return stack.getLast();
        }
    }

    public T pop(){         //возвращает верхний элмент и удаляет его из стека
        if(count == 0){
            pop_status = pop_err;
            return null;
        }else{
            pop_status = pop_ok;
            count--;
            return stack.remove(count);
        }
    }

    public void push(T elem){       //добавляет элемент в стек
        if(count == size){
            push_status = push_err;
        }else{
            stack.add(elem);
            count++;
            push_status = push_ok;
        }
    }

    public void clear(){        //очищает стек
        stack = new LinkedList<>();
        count = 0;
        pop_status = pop_init;
        peek_status = peek_init;
    }

    public int getCount() {     //возвращает количество элементов в стеке
        return count;
    }

    //запрос статусов операций
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
