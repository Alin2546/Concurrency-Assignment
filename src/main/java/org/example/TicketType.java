package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;


import java.util.Random;


@Getter
@AllArgsConstructor
public enum TicketType {
    FULL("full"),
    FULLVIP("full-vip"),
    FREEPASS("free-pass"),
    ONEDAY("one-day"),
    ONEDAYVIP("one-day-vip");

    private final String ticketType;

    /**
     * @return ticket type based on number generated [1,5]
     */
    static TicketType generateRandom() {
        Random random = new Random();
        int randomNumber = random.nextInt(5) + 1;
        return switch (randomNumber) {
            case 1 -> FULL;
            case 2 -> FULLVIP;
            case 3 -> FREEPASS;
            case 4 -> ONEDAY;
            case 5 -> ONEDAYVIP;
            default -> null;
        };
    }


}
