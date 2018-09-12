import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class Ranking {
    private final List<Event> events;

    public Ranking(List<Event> events) {
        this.events = events;
    }

    public List<Rank> byAuthor() {
        return eventsByAuthor()
                .map(Rank::from)
                .collect(Collectors.toList());
    }

    private Stream<Map.Entry<String, List<Event>>> eventsByAuthor() {
        return events.stream().collect(groupingBy(Event::author)).entrySet().stream();
    }
}