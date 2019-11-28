package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-20
 */
class ForwardCountTest {
    private final int INIT_COUNT = 0;

    @Test
    void constructor() {
        ForwardCount raceCount = new ForwardCount();
        assertEquals(raceCount.getCount(), INIT_COUNT);
    }

    @Test
    void race_true() {
        ForwardCount raceCount = new ForwardCount();
        raceCount.race(true);
        assertEquals(raceCount.getCount(), INIT_COUNT + 1);
    }

    @Test
    void race_false() {
        ForwardCount raceCount = new ForwardCount();
        raceCount.race(false);
        assertEquals(raceCount.getCount(), INIT_COUNT);
    }

    @Test
    void equals() {
        ForwardCount target = new ForwardCount();
        ForwardCount source = new ForwardCount();

        assertEquals(target, source);
    }

    @Test
    void equals_race() {
        ForwardCount target = new ForwardCount();
        target.race(true);
        ForwardCount source = new ForwardCount();
        source.race(true);

        assertEquals(target, source);
    }

    @Test
    void not_equals() {
        ForwardCount target = new ForwardCount();
        ForwardCount source = new ForwardCount();
        source.race(true);

        assertNotEquals(target, source);
    }

    @Test
    void isSameCount() {
        int count = 1;
        ForwardCount forwardCount = new ForwardCount();
        assertFalse(forwardCount.isSameCount(count));
        forwardCount.race(true);
        assertTrue(forwardCount.isSameCount(count));
    }
}