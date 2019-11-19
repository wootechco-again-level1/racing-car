package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    private Cars cars;
    private RacingGame racingGame;

    @Test
    @DisplayName("차들의 최종 이동 결과를 도출한다.")
    void generateGameResult() {
        cars = new Cars(Arrays.asList(
                new Car("a", 1),
                new Car("b", 3),
                new Car("c", 5))
        );
        racingGame = new RacingGame(cars);

        GameResult expected = new GameResult(Arrays.asList(
                new MovedCar("a", 1),
                new MovedCar("b", 3),
                new MovedCar("c", 5))
        );
        GameResult actual = racingGame.generateGameResult();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("게임이 끝나고 최종 라운드의 차 이동 결과와 결과를 도출하기 위한 GameResult의 차 이동 결과가 같다.")
    void equal_finalRoundResult_gameResult() {
        cars = new Cars(Arrays.asList(
                new Car("a"),
                new Car("b"),
                new Car("c"))
        );
        racingGame = new RacingGame(cars);

        int numberOfRound = 5;
        RoundResults roundResults = racingGame.startGame(numberOfRound);
        List<MovedCar> finalRoundResult = roundResults.get(numberOfRound - 1).getMovedCars();
        GameResult gameResult = racingGame.generateGameResult();

        assertThat(new GameResult(finalRoundResult)).isEqualTo(gameResult);
    }
}
