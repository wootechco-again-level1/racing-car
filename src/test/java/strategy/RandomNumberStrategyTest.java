package strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-24
 */
class RandomNumberStrategyTest {
    @Test
    void predicate() {
        RandomNumberStrategy moveStrategy = new RandomNumberStrategy();
        assertTrue(moveStrategy.predicate(4));
        assertFalse(moveStrategy.predicate(3));
    }
}