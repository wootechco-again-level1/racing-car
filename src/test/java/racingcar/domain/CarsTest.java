package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import racingcar.service.FixMove;
import racingcar.service.RandomMove;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    
    private static final Logger logger = LoggerFactory.getLogger(CarsTest.class);

    @Test
    @DisplayName("전체 자동차 고정 이동")
    void fixExecuteTest() {
        Cars cars = new Cars(Arrays.asList("car1", "car2", "car3"));
        cars.execute(new FixMove());

        List<Integer> carPositions = cars.getCars().stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());

        int expected = 1;

        carPositions.forEach(actual -> assertThat(actual).isEqualTo(expected));
    }

    @Test
    @DisplayName("전체 자동차 랜덤 이동")
    void randomExecuteTest() {
        Cars cars = new Cars(Arrays.asList("car1", "car2", "car3", "car4", "car5"));
        cars.execute(new RandomMove());

        List<Integer> carPositions = cars.getCars().stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());

        carPositions.forEach(position -> logger.info("car position : {}", position));
    }

    @Test
    @DisplayName("전체 자동차 고정 이동 후 최대 거리")
    void maxDistanceCarsTest() {
        Cars cars = new Cars(Arrays.asList("car1", "car2", "car3"));
        cars.execute(new FixMove());

        List<Car> actual = cars.getMaxPositionCars();
        List<Car> expected = new Cars(Arrays.asList("car1", "car2", "car3")).getCars();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("전체 자동차 랜덤 이동 후 최대 거리")
    void maxDistanceCars2() {
        Cars cars = new Cars(Arrays.asList("car1", "car2", "car3", "car4", "car5"));
        cars.execute(new RandomMove());

        List<Car> maxPositionCars = cars.getMaxPositionCars();

        maxPositionCars.forEach(car -> logger.info("{}", car));
    }

    @Test
    @DisplayName("라운드 마다 결과 저장")
    void getPositionsTest() {
        List<String> values = Arrays.asList("car1", "car2", "car3");
        Cars cars = new Cars(values);
        cars.execute(new FixMove());
        Map<String, Integer> actual = cars.getPositions();

        Map<String, Integer> expected = new HashMap<>();
        values.forEach(value -> expected.put(value, 1));

        values.forEach(value -> assertThat(actual.get(value)).isEqualTo(expected.get(value)));
    }
}