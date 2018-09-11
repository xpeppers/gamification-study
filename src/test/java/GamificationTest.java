import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GamificationTest {
    @Test
    public void shouldAddAnEvent() {

        Gamification gamification = new Gamification();
        gamification.addEvent(new Event("My first presentation", "MAF"));

        assertThat(gamification.events().size()).isEqualTo(1);
    }
}
