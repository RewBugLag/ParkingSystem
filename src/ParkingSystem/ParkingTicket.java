package ParkingSystem;

import java.time.LocalDateTime;
import java.util.Comparator;

/**
 * Ticket
 */
public class ParkingTicket {

    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private int fee;

    public ParkingTicket() {
        this.entryTime = LocalDateTime.now();
    }

    
    public static Comparator<LocalDateTime> hourComparator = new Comparator<LocalDateTime>() {
        
        @Override
        public int compare(LocalDateTime o1, LocalDateTime o2) {
            return o2.getHour() - o1.getHour();
        }
        
    };
    
    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public int getFee() {
        return fee;
    }

    public void exit() {
        exitTime = LocalDateTime.now();
        fee();
    }
    
    private boolean fee() {
        if (entryTime == null || exitTime == null) {
            return false;
        }
        fee = hourComparator.compare(entryTime, exitTime);
        if (exitTime.getMinute() - entryTime.getMinute() == 0) {
            if (exitTime.getSecond() - entryTime.getSecond() != 0) {
                fee += 1;
                fee *= 20;
                return true;
            }
        }
        fee += 1; // min != 0
        fee *= 20; // 20 bath per hour
        return true;
    }
}