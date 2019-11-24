package racingcar.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.service.FixMove;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RoundResultTest {

    @Test
    @DisplayName("라운드마다 실행 결과 갱")
    void updateTest() {
        RoundResult roundResult = new RoundResult();
        Map<String, Integer> before = roundResult.getPositions();
        before.values().forEach(value -> assertThat(value).isEqualTo(0));

        Cars cars = new Cars("car1, car2, car3");
        cars.execute(new FixMove());
        roundResult.update(cars);
        Map<String, Integer> after = roundResult.getPositions();

        after.values().forEach(value -> assertThat(value).isEqualTo(1));
    }
}