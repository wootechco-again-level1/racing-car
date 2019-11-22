package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.exception.IllegalCarNameException;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-21
 */
class CarsTest {
    private List<String> names = Arrays.asList("car1", "car2", "car3");
    private IntPredicate defaultDetermineMovement;
    private Cars cars;

    @BeforeEach
    void setUp() {
        defaultDetermineMovement = number -> true;
        cars = new Cars(names, defaultDetermineMovement);
    }

    @Test
    void constructor() {
        cars = new Cars(names, defaultDetermineMovement);
        assertEquals(cars.size(), 3);
    }

    @Test
    void constructor_name_duplicate_exception() {
        List<String> inputNames = Arrays.asList("car", "dar", "car");
        assertThrows(IllegalCarNameException.class, () -> new Cars(inputNames, defaultDetermineMovement));
    }

    @Test
    void constructor_list() {
        List<Car> carList = Arrays.asList(new Car("car1", defaultDetermineMovement), new Car("car2", defaultDetermineMovement));
        Cars cars = new Cars(carList);
        assertEquals(cars.size(), 2);
    }

    @Test
    void constructor_list_name_duplicate_exception() {
        List<Car> carList = Arrays.asList(new Car("car1", defaultDetermineMovement), new Car("car1", defaultDetermineMovement));
        assertThrows(IllegalCarNameException.class, () -> new Cars(carList));
    }

    @Test
    void constructor_list_of() {
        Cars cars = Cars.of(new Car("car1", defaultDetermineMovement), new Car("car2", defaultDetermineMovement));
        assertEquals(cars.size(), 2);
    }

    @Test
    void race() {
        cars.race();
        cars.forEach(car -> {
            assertEquals(car.getForwardCount(), 1);
        });
    }

    @Test
    void generateWinners() {
        Car winner1 = new Car("car1", number -> true);
        Car loser = new Car("car2", number -> false);
        Car winner2 = new Car("car3", number -> true);
        Cars cars = Cars.of(winner1, loser, winner2);
        cars.race();

        Cars winners = cars.generateWinner();
        assertEquals(winners, Cars.of(winner1, winner2));
    }
}