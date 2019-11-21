package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-20
 */
class RaceCountTest {
    private final int DEFAULT_PLAY_COUNT = 5;
    private RaceCount raceCount;

    @BeforeEach
    void setUp() {
        raceCount = new RaceCount(DEFAULT_PLAY_COUNT);
    }

    @Test
    void race_true() {
        raceCount.race(true);
        assertEquals(raceCount.getForwardCount(), 1);
        assertEquals(raceCount.getPlayCount(), DEFAULT_PLAY_COUNT - 1);
    }

    @Test
    void race_false() {
        raceCount.race(false);
        assertEquals(raceCount.getForwardCount(), 0);
        assertEquals(raceCount.getPlayCount(), DEFAULT_PLAY_COUNT - 1);
    }

    @Test
    void equals() {
        RaceCount target = new RaceCount(DEFAULT_PLAY_COUNT);
        RaceCount source = new RaceCount(DEFAULT_PLAY_COUNT);

        assertEquals(target, source);
    }

    @Test
    void equals_race() {
        RaceCount target = new RaceCount(5);
        target.race(false);
        RaceCount source = new RaceCount(4);

        assertEquals(target, source);
    }

    @Test
    void not_equals() {
        RaceCount target = new RaceCount(5);
        target.race(true);
        RaceCount source = new RaceCount(4);

        assertNotEquals(target, source);
    }
}