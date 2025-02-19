package org.example;


import java.util.Random;

/**
 * Entry point
 * The program wakes up every 5 seconds , reads from the gate queue and generates statistics based on the queue data
 */
public class App {
    public static void main(String[] args) {
        FestivalGate festivalGate = new FestivalGate();
        FestivalStatisticsThread festivalStatisticsThread = new FestivalStatisticsThread(festivalGate);
        festivalStatisticsThread.start();

        for (int i = 0; i < 100; i++) {
            TicketType ticketType = TicketType.generateRandom();
            FestivalAttendeeThread attendee = new FestivalAttendeeThread(ticketType, festivalGate);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
