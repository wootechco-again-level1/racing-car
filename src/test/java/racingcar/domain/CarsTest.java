package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import racingcar.controller.RandomMove;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    
    private static final Logger logger = LoggerFactory.getLogger(CarsTest.class);
    private static final String THREE_CARS = "car1, car2, car3";
    private static final String FIVE_CARS = "car1, car2, car3, car4, car5";

    @Test
    @DisplayName("전체 자동차 고정 이동")
    void fixExecuteTest() {
        Cars cars = new Cars(THREE_CARS);
        cars.execute(() -> true);

        List<Integer> carPositions = cars.getCars().stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());

        int expected = 1;

        carPositions.forEach(actual -> assertThat(actual).isEqualTo(expected));
    }

    @Test
    @DisplayName("전체 자동차 랜덤 이동")
    void randomExecuteTest() {
        Cars cars = new Cars(FIVE_CARS);
        cars.execute(new RandomMove());

        List<Integer> carPositions = cars.getCars().stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());

        carPositions.forEach(position -> logger.info("car position : {}", position));
    }

    @Test
    @DisplayName("전체 자동차 고정 이동 후 최대 거리")
    void maxDistanceCarsTest() {
        Cars cars = new Cars(THREE_CARS);
        cars.execute(() -> true);

        List<Car> actual = cars.getMaxPositionCars();
        List<Car> expected = new Cars(THREE_CARS).getCars();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("전체 자동차 랜덤 이동 후 최대 거리")
    void maxDistanceCars2() {
        Cars cars = new Cars(FIVE_CARS);
        cars.execute(new RandomMove());

        List<Car> maxPositionCars = cars.getMaxPositionCars();

        maxPositionCars.forEach(car -> logger.info("{}", car));
    }

    @Test
    @DisplayName("라운드 마다 결과 저장")
    void getPositionsTest() {
        List<String> values = Arrays.asList("car1", "car2", "car3");
        Cars cars = new Cars(THREE_CARS);
        cars.execute(() -> true);
        Map<String, Integer> actual = cars.getPositions();

        Map<String, Integer> expected = new HashMap<>();
        values.forEach(value -> expected.put(value, 1));

        values.forEach(value -> assertThat(actual.get(value)).isEqualTo(expected.get(value)));
    }

    @Test
    @DisplayName("자동차 이름 파싱")
    void parsedCarNamesTest() {
        String names1 = "car1,car2,car3";
        String names2 = "car1, car2, car3";
        String names3 = "ca r 1, c ar 2 , c a r 3   ";

        Cars cars1 = new Cars(names1);
        Cars cars2 = new Cars(names2);
        Cars cars3 = new Cars(names3);

        List<Car> expected = Arrays.asList(new Car("car1"), new Car("car2"), new Car("car3"));
        assertThat(cars1.getCars()).isEqualTo(expected);
        assertThat(cars2.getCars()).isEqualTo(expected);
        assertThat(cars3.getCars()).isEqualTo(expected);
    }
}