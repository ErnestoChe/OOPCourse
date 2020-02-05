package com.company;

public class Main {

    public static void main(String[] args) {
	    BoundedStack<Integer> bs = new BoundedStack<>(4);
        bs.log("after creating");
        bs.push(1);
        bs.log("after pushing 1");
        bs.peek();
        bs.log("after peeking");
        bs.push(2);
        bs.push(2);
        bs.push(2);
        System.out.println(bs.getSize());
        bs.log("after pushing two times");
        bs.push(2);
        System.out.println(bs.getSize());
        bs.log("after pushing three times");
        bs.push(2);
        System.out.println(bs.getSize());
        bs.log("after pushing four times");

        System.out.println("------------------");
        BoundedStack<Integer> bs2 = new BoundedStack<>(3);
        bs2.push(1);
        bs2.push(2);
        bs2.push(3);
        System.out.println(bs2.peek());
        System.out.println(bs2.pop());
        bs2.log("popping 3");
        System.out.println(bs2.pop());
        System.out.println(bs2.pop());
        bs2.log("popping all");
        System.out.println(bs2.pop());
        System.out.println(bs2.peek());
        bs2.log("empty");
    }
}
