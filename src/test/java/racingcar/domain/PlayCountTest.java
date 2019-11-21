package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.exception.IllegalRaceCountException;

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
class PlayCountTest {
    @Test
    void constructor_count() {
        int count = 10;
        PlayCount playCount = new PlayCount(count);
        assertEquals(playCount.getCount(), count);
    }

    @ParameterizedTest
    @MethodSource("invalidCounts")
    void constructor_count_exception(final int invalidCount) {
        assertThrows(IllegalRaceCountException.class, () -> {
            new PlayCount(invalidCount);
        });
    }

    private static Stream<Integer> invalidCounts() {
        return Stream.of(0, -1);
    }

    @Test
    void decrease() {
        int initCount = 3;
        PlayCount playCount = new PlayCount(initCount);
        playCount.decrease();
        assertEquals(playCount.getCount(), --initCount);
    }

    @Test
    void decrease_exception() {
        PlayCount playCount = new PlayCount(1);
        assertThrows(IllegalRaceCountException.class, () -> {
            playCount.decrease();
            playCount.decrease();
        });
    }

    @Test
    void isZero() {
        PlayCount playCount = new PlayCount(1);
        assertFalse(playCount.isZero());
        playCount.decrease();
        assertTrue(playCount.isZero());
    }

    @Test
    void equals() {
        PlayCount target = new PlayCount(2);
        PlayCount source = new PlayCount(2);

        assertEquals(target, source);
    }

    @Test
    void equals_decrease() {
        PlayCount target = new PlayCount(2);
        PlayCount source = new PlayCount(3);
        source.decrease();

        assertEquals(target, source);
    }

    @Test
    void not_equals() {
        PlayCount target = new PlayCount(2);
        PlayCount source = new PlayCount(2);
        source.decrease();

        assertNotEquals(target, source);
    }
}