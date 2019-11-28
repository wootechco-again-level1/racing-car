package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.exception.RaceNotCountException;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-20
 */
class RaceCountTest {
    @Test
    void constructor_count() {
        int count = 10;
        RaceCount raceCount = new RaceCount(count);
        assertEquals(raceCount.getCount(), count);
    }

    @ParameterizedTest
    @MethodSource("invalidCounts")
    void constructor_count_exception(final int invalidCount) {
        assertThrows(RaceNotCountException.class, () -> {
            new RaceCount(invalidCount);
        });
    }

    private static Stream<Integer> invalidCounts() {
        return Stream.of(0, -1);
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
        RaceCount raceCount = new RaceCount(1);
        assertThrows(RaceNotCountException.class, () -> {
            raceCount.decrease();
            raceCount.decrease();
        });
    }

    @Test
    void isZero() {
        RaceCount raceCount = new RaceCount(1);
        assertFalse(raceCount.isZero());
        raceCount.decrease();
        assertTrue(raceCount.isZero());
    }

    @Test
    void equals() {
        RaceCount target = new RaceCount(2);
        RaceCount source = new RaceCount(2);

        assertEquals(target, source);
    }

    @Test
    void equals_decrease() {
        RaceCount target = new RaceCount(2);
        RaceCount source = new RaceCount(3);
        source.decrease();

        assertEquals(target, source);
    }

    @Test
    void not_equals() {
        RaceCount target = new RaceCount(2);
        RaceCount source = new RaceCount(2);
        source.decrease();

        assertNotEquals(target, source);
    }
}