package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.exception.IllegalRaceCountException;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-20
 */
class PlayRaceCountTest {
    @Test
    void constructor_count() {
        int count = 10;
        PlayRaceCount playRaceCount = new PlayRaceCount(count);
        assertEquals(playRaceCount.getCount(), count);
    }

    @ParameterizedTest
    @MethodSource("invalidCounts")
    void constructor_count_exception(final int invalidCount) {
        assertThrows(IllegalRaceCountException.class, () -> {
            new PlayRaceCount(invalidCount);
        });
    }

    private static Stream<Integer> invalidCounts() {
        return Stream.of(0, -1);
    }

    @Test
    void decrease() {
        int initCount = 3;
        PlayRaceCount playRaceCount = new PlayRaceCount(initCount);
        playRaceCount.decrease();
        assertEquals(playRaceCount.getCount(), --initCount);
    }

    @Test
    void decrease_exception() {
        PlayRaceCount playRaceCount = new PlayRaceCount(1);
        assertThrows(IllegalRaceCountException.class, () -> {
            playRaceCount.decrease();
            playRaceCount.decrease();
        });
    }

    @Test
    void isZero() {
        PlayRaceCount playRaceCount = new PlayRaceCount(1);
        assertFalse(playRaceCount.isZero());
        playRaceCount.decrease();
        assertTrue(playRaceCount.isZero());
    }
}