package com.company;

import java.util.LinkedList;

/**
 * В параметр класс элементов <T>
 * Стек со стандартными функциями
 * В отличие от обычного стека имеет максимальный размер,
 * задаваемый при создании
 */
class BoundedStack<T> {

    //приватные поля
    private LinkedList<T> stack;
    private int size;
    private int count;

    private int pop_status;
    private int peek_status;
    private int push_status;

    private final int pop_init = 0; //pop не вызывалась
    private final int pop_ok = 1;   //последнее выполнение успешно
    private final int pop_err = 2;  //пустой стек

    private final int peek_init = 0; //peek не вызывалась
    private final int peek_ok = 1;   //последний вызов вернул корректное значение
    private final int peek_err = 2;  //пустой стек

    private final int push_init = 0; //ни одного элемента не добавлялось
    private final int push_ok = 1;   //последнее добавление успешно
    private final int push_err = 2;  //не хватает места под новый элемент

    //конструктор с размером
    //постусловие
    // задает начальные статусы для команд peek() pop() push()
    // создан пустой стек
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

    //возвращает верхний элмент и удаляет его из стека
    //предусловие стек не пустой
    //постусловие из стека удаляется верхний
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

    //добавляет элемент в стек
    //предусловие размер стека не превышен
    //добавляется элемент
    public void push(T elem){
        if(count == size){
            push_status = push_err;
        }else{
            stack.add(elem);
            count++;
            push_status = push_ok;
        }
    }

    //очищает стек
    //постусловие пустой стек с тем же размером
    //задает начальные статусы для команд peek() pop() push()
    public void clear(){
        stack = new LinkedList<>();
        count = 0;
        pop_status = pop_init;
        peek_status = peek_init;
    }

    //запросы:
    //предусловие стек не пустой
    public T peek(){
        if(count == 0){
        peek_status = peek_err;
        return null;
        }else{
            peek_status = peek_ok;
            return stack.getLast();
        }
    }
    //запрос количества элементов в стеке
    public int getSize(){
        return count;
    }

    //запрос статусов операций
    public int getPop_status(){//pop status
        return pop_status;
    }
    public int getPeek_status(){//peek status
        return peek_status;
    }
    public int getPush_status(){//push status
        return push_status;
    }
    public void log(String text){
        System.out.println(text);
        System.out.println(getPop_status() + " pop status");
        System.out.println(getPeek_status() + " peek status");
        System.out.println(getPush_status() + " push status");

    }
}
