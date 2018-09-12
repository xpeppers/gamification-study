import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class GamificationTest {
    private Gamification gamification;

    @Before
    public void setUp() {
        gamification = new Gamification();
    }

    @Test
    public void shouldAddAnEvent() {
        gamification.addEvent(new Event("My first presentation", "author"));

        assertThat(gamification.futureEvents().size()).isEqualTo(1);
    }

    @Test
    public void shouldAddAScheduledEvent() {
        LocalDateTime now = LocalDateTime.now().plusHours(1);

        gamification.addEvent(new Event("My scheduled presentation", "author", now));

        assertThat(gamification.futureEvents().stream().findFirst().get().scheduledOn()).isEqualTo(now);
    }

    @Test
    public void shouldExcludePastEvents() {
        LocalDateTime now = LocalDateTime.now().minusDays(1);

        gamification.addEvent(new Event("My scheduled presentation", "author", now));

        assertThat(gamification.futureEvents()).isEmpty();
    }

    @Test
    public void shouldScheduleAnEventAlreadyPresent() {
        LocalDateTime nextDay = LocalDateTime.now().plusDays(1);
        gamification.addEvent(new Event("My not scheduled date", "author"));

        gamification.scheduleOn(new Event("My not scheduled date", "author"), nextDay);

        assertThat(gamification.futureEvents().stream().findFirst().get().scheduledOn()).isEqualTo(nextDay);
    }
}
