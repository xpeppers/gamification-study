import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


public class EventTest {

    @Test
    public void shouldBeEqualTo() {
        assertThat(new Event("title", "author")).isEqualTo(new Event("title", "author"));
    }

    @Test
    public void shouldBeDifferentFrom() {
        assertThat(new Event("another title", "author")).isNotEqualTo(new Event("title", "author"));
        assertThat(new Event("title", "another author")).isNotEqualTo(new Event("title", "author"));
        assertThat(new Event("title", "author")).isNotEqualTo(new Event("title", "author").scheduleOn(LocalDateTime.now()));
    }
}