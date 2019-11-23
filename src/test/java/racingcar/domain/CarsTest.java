package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import racingcar.FixMove;
import racingcar.RandomMove;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    
    private static final Logger logger = LoggerFactory.getLogger(CarsTest.class);

    @Test
    @DisplayName("전체 자동차 고정 테스트")
    void fixExecuteTest() {
        Cars cars = new Cars(Arrays.asList("car1", "car2", "car3", "car4", "car5"));
        cars.execute(new FixMove());

        List<Position> carPositions = cars.getCars().stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());

        Position expected = new Position();
        expected.increase();

        carPositions.forEach(actual -> assertThat(actual).isEqualTo(expected));
    }

    @Test
    @DisplayName("전체 자동차 랜덤 이동")
    void randomExecuteTest() {
        Cars cars = new Cars(Arrays.asList("car1", "car2", "car3", "car4", "car5"));
        cars.execute(new RandomMove());

        List<Position> carPositions = cars.getCars().stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());

        carPositions.forEach(position -> logger.info("car position : {}", position.getPosition()));
    }
}