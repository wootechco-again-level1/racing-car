package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-21
 */
class CarsTest {
    private List<String> names = Arrays.asList("car1", "car2", "car3");
    private final int DEFAULT_RACE_COUNT = 5;
    private IntPredicate defaultDetermineMovement;
    private Cars cars;

    @BeforeEach
    void setUp() {
        defaultDetermineMovement = number -> true;
        cars = new Cars(names, DEFAULT_RACE_COUNT, defaultDetermineMovement);
    }

    @Test
    void constructor() {
        cars = new Cars(names, DEFAULT_RACE_COUNT, defaultDetermineMovement);
        assertEquals(cars.size(), 3);
    }

    @Test
    void constructor_list() {
        List<Car> carList = Arrays.asList(new Car("car1", DEFAULT_RACE_COUNT, defaultDetermineMovement), new Car("car2", DEFAULT_RACE_COUNT, defaultDetermineMovement));
        Cars cars = new Cars(carList);
        assertEquals(cars.size(), 2);
    }

    @Test
    void constructor_list_of() {
        Cars cars = Cars.of(new Car("car1", DEFAULT_RACE_COUNT, defaultDetermineMovement), new Car("car2", DEFAULT_RACE_COUNT, defaultDetermineMovement));
        assertEquals(cars.size(), 2);
    }

    @Test
    void race() {
        cars.race();
        cars.forEach(car -> {
            assertEquals(car.getPlayCount(), DEFAULT_RACE_COUNT - 1);
            assertEquals(car.getForwardCount(), 1);
        });
    }
}