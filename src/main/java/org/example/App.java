package org.example;


import java.util.Random;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        FestivalGate festivalGate = new FestivalGate();

        for (int i = 0; i < 100; i++) {
            TicketType ticketType = TicketType.generateRandom();
            FestivalAttendeeThread attendee = new FestivalAttendeeThread(ticketType, festivalGate);
            System.out.println(attendee.getTicketType());
        }
        FestivalStatisticsThread festivalStatisticsThread = new FestivalStatisticsThread(festivalGate);
        festivalStatisticsThread.start();


    }
}
