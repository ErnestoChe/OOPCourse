package com.company;

import java.util.LinkedList;

/**
 * в параметр класс элементов <T>
 * в отличие от обычного стека имеет максимальный размер,
 * задаваемый при создании
 *
 */
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

    //конструктор с размером
    //задает начальные статусы для команд peek() pop() push()
    BoundedStack(int size){ }
    //стандартный конструктор(по дефолту размер 32)
    //задает начальные статусы для команд peek() pop() push()
    BoundedStack(){ }

    //возвращает верхний элемент из стека без удаления
    //предусловие стек не пустой
    public T peek(){ }

    //возвращает верхний элмент и удаляет его из стека
    //предусловие стек не пустой
    //постусловие из стека удаляется верхний
    public T pop(){ }


    //добавляет элемент в стек
    //постусловие если не превышен размер, добавляется элемент
    public void push(T elem){ }

    //очищает стек
    //постусловие пустой стек с тем же размером
    //задает начальные статусы для команд peek() pop() push()
    public void clear(){ }

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
