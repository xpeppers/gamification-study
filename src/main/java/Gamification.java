import java.util.ArrayList;
import java.util.List;

public class Gamification {
    private List<Event> events = new ArrayList<Event>();

    public void addEvent(Event event) {
        events.add(event);
    }

    public List<Event> events() {
        return events;
    }
}
