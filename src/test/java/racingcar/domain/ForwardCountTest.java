package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
    void increase() {
        ForwardCount raceCount = new ForwardCount();
        raceCount.increase();
        assertEquals(raceCount.getCount(), INIT_COUNT + 1);
    }

    @Test
    void equals() {
        ForwardCount target = new ForwardCount();
        ForwardCount source = new ForwardCount();

        assertEquals(target, source);
    }

    @Test
    void equals_increase() {
        ForwardCount target = new ForwardCount();
        target.increase();
        ForwardCount source = new ForwardCount();
        source.increase();

        assertEquals(target, source);
    }

    @Test
    void not_equals() {
        ForwardCount target = new ForwardCount();
        ForwardCount source = new ForwardCount();
        source.increase();

        assertNotEquals(target, source);
    }
}