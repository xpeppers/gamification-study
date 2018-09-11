import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.time.LocalDateTime;

public class Event {
    private LocalDateTime dateTime;
    private String title;
    private String author;

    public Event(String title, String author) {
        this(title, author, null);
    }

    public Event(String title, String author, LocalDateTime dateTime) {
        this.title = title;
        this.author = author;
        this.dateTime = dateTime;
    }

    public LocalDateTime scheduledOn() {
        return dateTime;
    }

    public boolean isScheduledInFuture() {
        if(scheduledOn() == null) return true;

        return scheduledOn().isAfter(LocalDateTime.now());
    }

    public void scheduleOn(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }
}
