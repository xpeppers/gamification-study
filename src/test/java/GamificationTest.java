import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class GamificationTest {
    public static final String AUTHOR = "MAF";
    private Gamification gamification;

    @Before
    public void setUp() {
        gamification = new Gamification();
    }

    @Test
    public void shouldAddsAnEvent() {
        gamification.addEvent(new Event("My first presentation", "MAF"));

        assertThat(gamification.futureEvents().size()).isEqualTo(1);
    }

    @Test
    public void shouldAddsAScheduledEvent() {
        LocalDateTime now = LocalDateTime.now().plusHours(1);

        gamification.addEvent(new Event("My scheduled presentation", AUTHOR, now));

        assertThat(gamification.futureEvents().stream().findFirst().get().scheduledOn()).isEqualTo(now);
    }

    @Test
    public void shouldExcludesPastEvents() {
        LocalDateTime now = LocalDateTime.now().minusDays(1);

        gamification.addEvent(new Event("My scheduled presentation", AUTHOR, now));

        assertThat(gamification.futureEvents()).isEmpty();
    }

    @Test
    public void shouldScheduleAnEventAlreadyPresent() {
        LocalDateTime nextDay = LocalDateTime.now().plusDays(1);
        gamification.addEvent(new Event("My not scheduled date", AUTHOR));

        gamification.scheduleOn(new Event("My not scheduled date", AUTHOR), nextDay);

        assertThat(gamification.futureEvents().stream().findFirst().get().scheduledOn()).isEqualTo(nextDay);
    }
}
