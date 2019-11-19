package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    @DisplayName("주행이 끝나고 차들의 최종 이동 결과를 도출한다.")
    void generateGameResult() {
        Cars cars = new Cars(Arrays.asList(
                new Car("a", 1),
                new Car("b", 3),
                new Car("c", 5))
        );
        RacingGame racingGame = new RacingGame(cars);

        GameResult expected = new GameResult(Arrays.asList(
                new MovedCar("a", 1),
                new MovedCar("b", 3),
                new MovedCar("c", 5))
        );
        GameResult actual = racingGame.generateGameResult();

        assertThat(actual).isEqualTo(expected);
    }
}
