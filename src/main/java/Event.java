import java.time.LocalDateTime;

public class Event {
    private LocalDateTime dateTime;

    public Event(String title, String author) {
    }

    public Event(String title, String author, LocalDateTime dateTime) {

        this.dateTime = dateTime;
    }

    public LocalDateTime scheduledOn() {
        return dateTime;
    }

    public boolean isScheduledInFuture() {
        if(scheduledOn() == null) return true;

        return scheduledOn().isAfter(LocalDateTime.now());
    }
}
