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
        PlayCount defaultPlayCount = new PlayCount(DEFAULT_PLAY_COUNT);
        raceCount = new RaceCount(defaultPlayCount);
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
        PlayCount playCount = new PlayCount(5);
        RaceCount target = new RaceCount(playCount);
        RaceCount source = new RaceCount(playCount);

        assertEquals(target, source);
    }

    @Test
    void equals_race() {
        RaceCount target = new RaceCount(new PlayCount(5));
        target.race(false);
        RaceCount source = new RaceCount(new PlayCount(4));

        assertEquals(target, source);
    }

    @Test
    void not_equals() {
        RaceCount target = new RaceCount(new PlayCount(5));
        target.race(true);
        RaceCount source = new RaceCount(new PlayCount(4));

        assertNotEquals(target, source);
    }
}