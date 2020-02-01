package com.company;

public class Main {

    public static void main(String[] args) {
	    BoundedStack<Integer> bs = new BoundedStack<>();
	    bs.pop();
        System.out.println(bs.getPop_status());
        System.out.println(bs.getPeek_status());
    }
}
