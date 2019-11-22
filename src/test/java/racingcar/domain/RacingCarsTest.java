package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.exception.RaceNotCountException;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
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
    private IntPredicate determineMovement;
    private RaceCount raceCount = new RaceCount(DEFAULT_RACE_COUNT);
    private RacingCars racingCars;

    @BeforeEach
    void setUp() {
        names = Arrays.asList("car1", "car2", "car3");
        determineMovement = number -> true;
        racingCars = new RacingCars(names, raceCount, determineMovement);
    }

    @Test
    void constructor() {
        Cars cars = new Cars(names, determineMovement);
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
        Car winner1 = new Car("car1", number -> true);
        Car loser = new Car("car3", number -> false);
        Car winner2 = new Car("car3", number -> true);
        Cars cars = Cars.of(winner1, loser, winner2);

        RacingCars racingCars = new RacingCars(cars, raceCount);
        IntStream.range(0, DEFAULT_RACE_COUNT).forEach(index -> racingCars.race());

        Cars winners = racingCars.generateFinalWinner();
        assertEquals(winners, Cars.of(winner1, winner2));
    }
}