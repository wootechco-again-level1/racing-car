package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-21
 */
class RacingCarsTest {
    private int PLAY_COUNT = 5;
    private List<String> names;
    private IntPredicate determineMovement;
    private RacingCars racingCars;

    @BeforeEach
    void setUp() {
        names = Arrays.asList("car1", "car2", "car3");
        determineMovement = number -> true;
        racingCars = new RacingCars(names, PLAY_COUNT, determineMovement);
    }

    @Test
    void constructor() {
        Cars cars = new Cars(names, PLAY_COUNT, determineMovement);
        assertEquals(racingCars.getCars(), cars);
    }

    @Test
    void hasNext() {
        assertFalse(racingCars.hasNext());
    }

    @Test
    void race() {
        IntStream.range(0, PLAY_COUNT).forEach(index -> racingCars.race());
        assertTrue(racingCars.hasNext());
    }
}