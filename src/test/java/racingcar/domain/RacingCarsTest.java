package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.exception.RaceNotCountException;
import strategy.MoveStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-21
 */
class RacingCarsTest {
    private int DEFAULT_RACE_COUNT = 5;
    private List<String> names;
    private MoveStrategy moveStrategy;
    private RaceCount raceCount = new RaceCount(DEFAULT_RACE_COUNT);
    private RacingCars racingCars;

    @BeforeEach
    void setUp() {
        names = Arrays.asList("car1", "car2", "car3");
        moveStrategy = () -> true;
        racingCars = new RacingCars(names, raceCount, moveStrategy);
    }

    @Test
    void constructor() {
        Cars cars = new Cars(names, moveStrategy);
        assertEquals(racingCars.getCars(), cars);
    }

    @Test
    void hasNext() {
        assertTrue(racingCars.hasNext());
    }

    @Test
    void race() {
        IntStream.range(0, DEFAULT_RACE_COUNT).forEach(index -> racingCars.race());
        assertFalse(racingCars.hasNext());
    }

    @Test
    void race_exception() {
        IntStream.range(0, DEFAULT_RACE_COUNT).forEach(index -> racingCars.race());
        assertThrows(RaceNotCountException.class, () -> racingCars.race());
    }

    @Test
    void generateFinalWinner() {
        Car winner1 = new Car("car1", () -> true);
        Car loser = new Car("car2", () -> false);
        Car winner2 = new Car("car3", () -> true);
        Cars cars = Cars.of(winner1, loser, winner2);
        Cars win = Cars.of(winner1, winner2);

        RacingCars racingCars = new RacingCars(cars, raceCount);
        IntStream.range(0, DEFAULT_RACE_COUNT).forEach(index -> racingCars.race());

        Winners winners = racingCars.generateFinalWinner();
        assertEquals(winners, new Winners(win));
    }
}