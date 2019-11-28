package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.exception.IllegalCarNameException;
import strategy.MoveStrategy;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-21
 */
class CarsTest {
    private List<String> names = Arrays.asList("car1", "car2", "car3");
    private MoveStrategy moveStrategy;
    private Cars cars;

    @BeforeEach
    void setUp() {
        moveStrategy = () -> true;
        cars = new Cars(names, moveStrategy);
    }

    @Test
    void constructor() {
        cars = new Cars(names, moveStrategy);
        assertEquals(cars.size(), 3);
    }

    @Test
    void constructor_name_duplicate_exception() {
        List<String> inputNames = Arrays.asList("car", "dar", "car");
        assertThrows(IllegalCarNameException.class, () -> new Cars(inputNames, moveStrategy));
    }

    @Test
    void constructor_list() {
        List<Car> carList = Arrays.asList(new Car("car1", moveStrategy), new Car("car2", moveStrategy));
        Cars cars = new Cars(carList);
        assertEquals(cars.size(), 2);
    }

    @Test
    void constructor_list_name_duplicate_exception() {
        List<Car> carList = Arrays.asList(new Car("car1", moveStrategy), new Car("car1", moveStrategy));
        assertThrows(IllegalCarNameException.class, () -> new Cars(carList));
    }

    @Test
    void constructor_list_of() {
        Cars cars = Cars.of(new Car("car1", moveStrategy), new Car("car2", moveStrategy));
        assertEquals(cars.size(), 2);
    }

    @Test
    void race() {
        cars.race();
        cars.forEach(car -> {
            assertEquals(car.getForwardCount(), 1);
        });
    }
}