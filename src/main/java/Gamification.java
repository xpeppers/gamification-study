import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Gamification {
    private List<Event> events = new ArrayList<>();

    public void addEvent(Event event) {
        events.add(event);
    }

    public List<Event> futureEvents() {
        return events.stream()
                .filter(each -> each.isScheduledInFuture())
                .collect(Collectors.toList());
    }

    public void scheduleOn(Event event, LocalDateTime dateTime) {
        events.stream().filter(each -> each.equals(event)).findFirst().get().scheduleOn(dateTime);
    }
}
