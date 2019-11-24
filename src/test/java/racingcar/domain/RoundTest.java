package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RoundTest {

    @Test
    void nextTest() {
        Round round = new Round(5);
        int before = round.getRound();

        round.next();
        int after = round.getRound();

        assertThat(before).isEqualTo(1);
        assertThat(after).isEqualTo(2);
        assertThat(before).isNotEqualTo(after);
    }

    @Test
    void isFinishedTest() {
        Round round = new Round(3);

        round.next();
        assertThat(round.isFinished()).isFalse();

        round.next();
        assertThat(round.isFinished()).isTrue();
    }
}