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

}
