package com.wsw.exercise03;

import com.wsw.exercise02.Singleton;

/**
 * @author loriyuhv
 * @ClassName TicketMaker
 * @date 2024/4/25 16:33
 * @description TODO
 */

public class TicketMaker {
    private final static TicketMaker ticketMaker = new TicketMaker();

    private TicketMaker() {}

    private int ticket = 1000;

    public int getNextTicketNumber() {
        return ticket++;
    }

    public static TicketMaker getInstance() {
        return ticketMaker;
        // return new TicketMaker();
    }
}
