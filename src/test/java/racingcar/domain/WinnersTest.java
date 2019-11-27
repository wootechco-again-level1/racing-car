package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-27
 */
class WinnersTest {
    @Test
    void constructor() {
        Car winner1 = new Car("car1", () -> true);
        Car loser = new Car("car2", () -> false);
        Car winner2 = new Car("car3", () -> true);
        Cars cars = Cars.of(winner1, loser, winner2);
        Cars win = Cars.of(winner1, winner2);
        cars.race();

        Winners winners = new Winners(cars);
        assertEquals(winners, new Winners(win));
    }

}