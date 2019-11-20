package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.exception.IllegalRaceCountException;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-20
 */
class RaceCountTest {
    @Test
    void constructor() {
        RaceCount raceCount = new RaceCount();
        assertTrue(raceCount.isZero());
    }

    @Test
    void constructor_count() {
        int count = 10;
        RaceCount raceCount = new RaceCount(count);
        assertEquals(raceCount.getCount(), count);
    }

    @ParameterizedTest
    @MethodSource("invalidCounts")
    void constructor_count_exception(final int invalidCount) {
        assertThrows(IllegalRaceCountException.class, () -> {
            new RaceCount(invalidCount);
        });
    }

    private static Stream<Integer> invalidCounts() {
        return Stream.of(0, -1);
    }

    @Test
    void increase() {
        int initCount = 1;
        RaceCount raceCount = new RaceCount(initCount);
        raceCount.increase();
        assertEquals(raceCount.getCount(), ++initCount);
    }

    @Test
    void decrease() {
        int initCount = 3;
        RaceCount raceCount = new RaceCount(initCount);
        raceCount.decrease();
        assertEquals(raceCount.getCount(), --initCount);
    }

    @Test
    void decrease_exception() {
        RaceCount raceCount = new RaceCount();
        assertThrows(IllegalRaceCountException.class, () -> {
            raceCount.decrease();
        });
    }
}