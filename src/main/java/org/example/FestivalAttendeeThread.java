package org.example;

public class FestivalAttendeeThread extends Thread {
    private final TicketType ticketType;
    private final FestivalGate festivalGate;

    FestivalAttendeeThread(TicketType ticketType, FestivalGate festivalGate) {
        this.ticketType = ticketType;
        this.festivalGate = festivalGate;
        festivalGate.ticketTypeList.add(ticketType);
    }
}
