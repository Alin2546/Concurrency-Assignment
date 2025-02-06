package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
public class FestivalAttendeeThread extends Thread {
    private TicketType ticketType;
    private FestivalGate festivalGate;

    FestivalAttendeeThread(TicketType ticketType, FestivalGate festivalGate) {
        this.ticketType = ticketType;
        this.festivalGate = festivalGate;
        festivalGate.ticketTypeList.add(ticketType);
    }

}
