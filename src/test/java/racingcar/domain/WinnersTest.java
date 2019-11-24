package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.RacingGame;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {
    @Test
    @DisplayName("우승자 잘 구하는지")
    void winnerTest() {
        RacingGame racingGame = new RacingGame("car1, car2, car3", 5);
        Winners winners = racingGame.getWinners();
        List<String> actual = winners.getWinnerNames();

        List<String> expected = Arrays.asList("car1", "car2", "car3");

        assertThat(actual).isEqualTo(expected);
    }
}