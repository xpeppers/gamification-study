import org.apache.commons.lang3.builder.EqualsBuilder;

import java.time.LocalDateTime;

public class Event {
    private LocalDateTime dateTime;
    private String title;
    private String author;

    public Event(String title, String author) {
        this.title = title;
        this.author = author;
        this.dateTime = null;
    }

    public LocalDateTime scheduledOn() {
        return dateTime;
    }

    public boolean isScheduledInFuture() {
        if (scheduledOn() == null) return true;

        return scheduledOn().isAfter(LocalDateTime.now());
    }

    public Event scheduleOn(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    public String author() {
        return author;
    }
}
