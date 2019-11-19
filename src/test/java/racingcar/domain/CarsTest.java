package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("한 라운드 후의 결과를 도출한다.")
    void roundResult() {
        Cars cars = new Cars(Arrays.asList(
                new Car("a"),
                new Car("b"),
                new Car("c")
        ));

        RoundResult expected = new RoundResult(Arrays.asList(
                new MovedCar("a", 0),
                new MovedCar("b", 0),
                new MovedCar("c", 1)
        ));

        List<Integer> movable = Arrays.asList(1, 3, 5);
        RoundResult actual = cars.round(movable);

        assertThat(actual).isEqualTo(expected);
    }
}
