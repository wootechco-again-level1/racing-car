package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RoundTest {

    @Test
    @DisplayName("마지막 라운드인지")
    void isFinishedTest() {
        Round round = new Round(2);
        round.next();
        round.next();

        assertThat(round.isFinished()).isTrue();
    }
}