package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RoundTest {

    @Test
    @DisplayName("다음 라운드 이동")
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
    @DisplayName("전체 라운드 종료 확인")
    void isFinishedTest() {
        Round round = new Round(3);

        round.next();
        assertThat(round.isFinished()).isFalse();

        round.next();
        assertThat(round.isFinished()).isTrue();
    }
}