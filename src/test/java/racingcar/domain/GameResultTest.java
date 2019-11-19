package racingcar.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameResultTest {

    @Test
    @DisplayName("주행 결과를 통해 최종 우승자를 도출한다.")
    void calculateWinner() {
        MovedCar fastestCar = new MovedCar("c", 3);
        List<MovedCar> movedCars = Arrays.asList(
                new MovedCar("a", 1),
                new MovedCar("b", 2),
                fastestCar
        );
        GameResult gameResult = new GameResult(movedCars);
        Winner winner = gameResult.calculateGameWinner();

        assertThat(winner).isEqualTo(new Winner(Arrays.asList(fastestCar)));
    }

    @Test
    @DisplayName("최종 우승자가 여러명인 경우 해당하는 모든 Car를 우승자로 도출한다.")
    void calculateWinners() {
        MovedCar one = new MovedCar("b", 3);
        MovedCar other = new MovedCar("c", 3);

        List<MovedCar> movedCars = Arrays.asList(
                new MovedCar("a", 1),
                one,
                other
        );

        GameResult gameResult = new GameResult(movedCars);
        Winner winner = gameResult.calculateGameWinner();

        assertThat(winner).isEqualTo(new Winner(Arrays.asList(one, other)));
    }

    @Test
    @DisplayName("Car가 한대도 없는 경우 NotExistMovedCarException을 일으킨다.")
    void winner_ifHasNoCar_thenNotExistMovedCarException() {
        GameResult gameResult = new GameResult(Lists.newArrayList());

        assertThatThrownBy(gameResult::calculateGameWinner).isInstanceOf(NotExistMovedCarException.class);
    }
}