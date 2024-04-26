package com.wsw.exercise03;

/**
 * @author loriyuhv
 * @ClassName Main
 * @date 2024/4/25 16:34
 * @description TODO
 */

// 1. 创建一个继承于Thread类的子类
class MyThread extends Thread {
    private static int ticket = 100;

    // 2.重写Thread类的run()
    @Override
    public void run() {
        TicketMaker ticketMaker = TicketMaker.getInstance();
        for (int i = 0; i < 100; i++) {
            int nextTicketNumber = ticketMaker.getNextTicketNumber();
            System.out.println(Thread.currentThread().getName() + ":" + nextTicketNumber);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        //3.创建Thread类子类的对象
        // MyThread t = new MyThread();
        // // 4. 通过此对象调用start()
        // t.start();
        // MyThread t2 = new MyThread();
        // t2.start();
        int nextTicketNumber = 0;
        TicketMaker instance = TicketMaker.getInstance();
        for (int i = 0; i < 100; i ++) {
            nextTicketNumber = instance.getNextTicketNumber();

        }
        System.out.println(nextTicketNumber);

        TicketMaker instance2 = TicketMaker.getInstance();
        for (int i = 0; i < 100; i ++) {
            nextTicketNumber = instance2.getNextTicketNumber();

        }
        System.out.println(nextTicketNumber);
    }
}
