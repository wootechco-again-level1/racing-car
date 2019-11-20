package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}