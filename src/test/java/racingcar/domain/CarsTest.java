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
    private RaceCount defaultRaceCount;
    private IntPredicate defaultDetermineMovement;

    @BeforeEach
    void setUp() {
        int DEFAULT_PLAY_COUNT = 5;
        defaultRaceCount = new RaceCount(new PlayCount(DEFAULT_PLAY_COUNT));
        defaultDetermineMovement = number -> true;
    }

    @Test
    void constructor() {
        Cars cars = new Cars(names, defaultRaceCount, defaultDetermineMovement);
        assertEquals(cars.size(), 3);
    }

    @Test
    void constructor_list() {
        List<Car> carList = Arrays.asList(new Car("car1", defaultRaceCount, defaultDetermineMovement), new Car("car2", defaultRaceCount, defaultDetermineMovement));
        Cars cars = new Cars(carList);
        assertEquals(cars.size(), 2);
    }

    @Test
    void constructor_list_of() {
        Cars cars = Cars.of(new Car("car1", defaultRaceCount, defaultDetermineMovement), new Car("car2", defaultRaceCount, defaultDetermineMovement));
        assertEquals(cars.size(), 2);
    }
}