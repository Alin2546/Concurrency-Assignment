package org.example;

import lombok.AllArgsConstructor;


public class FestivalStatisticsThread extends Thread {
    private FestivalGate festivalGate;
    private int countFull;
    private int countFree;
    private int countVip;
    private int countOneDay;
    private int countOneDayVip;


    FestivalStatisticsThread(FestivalGate festivalGate) {
        this.festivalGate = festivalGate;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (!(festivalGate.ticketTypeList.isEmpty())) {
            System.out.println(festivalGate.ticketTypeList.size() + " people entered");
            festivalGate.ticketTypeList.forEach(s -> {
                switch (s.getTicketType()) {
                    case "full" -> countFull++;
                    case "full-vip" -> countVip++;
                    case "free-pass" -> countFree++;
                    case "one-day" -> countOneDay++;
                    case "one-day-vip" -> countOneDayVip++;
                }
            });
            System.out.println(countFull + " people have full tickets");
            System.out.println(countVip + " people have full tickets");
            System.out.println(countFree + " people have free passes");
            System.out.println(countOneDay + " people have full tickets");
            System.out.println(countOneDayVip + " people have full tickets");

        }


    }
}
