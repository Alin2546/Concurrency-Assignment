package org.example;




public class FestivalStatisticsThread extends Thread {
    /**
     * Counting ticket types and number of attendees
     */
    private final FestivalGate festivalGate;
    private int countFull;
    private int countFree;
    private int countVip;
    private int countOneDay;
    private int countOneDayVip;
    private int countAttendees;


    FestivalStatisticsThread(FestivalGate festivalGate) {
        this.festivalGate = festivalGate;
    }

    /**
     * Gets the stats from the Gate queue , prints them and in the final it clears the queue
     */
    void getStats() {
        if (!(festivalGate.ticketTypeList.isEmpty())) {

            festivalGate.ticketTypeList.forEach(s -> {
                this.countAttendees++;
                switch (s.getTicketType()) {
                    case "full" -> countFull++;
                    case "full-vip" -> countVip++;
                    case "free-pass" -> countFree++;
                    case "one-day" -> countOneDay++;
                    case "one-day-vip" -> countOneDayVip++;
                }
            });
            System.out.println(this.countAttendees + " people entered");
            System.out.println(this.countFull + " people have full tickets");
            System.out.println(this.countFree + " people have free passes");
            System.out.println(this.countVip + " people have full VIP passes");
            System.out.println(this.countOneDay + " people have one-day passes");
            System.out.println(this.countOneDayVip + " people have one-day VIP passes");
        }
        festivalGate.ticketTypeList.clear();
    }

    /**
     * Calling the {@code getStats} every 5 seconds
     */
    @Override
    public void run() {
        for (var i = 0; i < 100; i++) {
            try {
                getStats();
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
