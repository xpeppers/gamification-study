import org.apache.commons.lang3.builder.EqualsBuilder;

import java.util.List;
import java.util.Map;

public class Rank {
    private final String author;
    private final int points;

    public Rank(String author, int points) {
        this.author = author;
        this.points = points;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    public static Rank from(Map.Entry<String, List<Event>> entry) {
        return new Rank(entry.getKey(), entry.getValue().size());
    }
}
