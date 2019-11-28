package strategy;

import java.util.Random;

/**
 * 0~9 사이의 임의의 숫자 중 4 이상일 경우 true가 나오는 전략.
 *
 * @author heebg
 * @version 1.0
 * @date 2019-11-24
 */
public class RandomNumberStrategy implements MoveStrategy {
    private static final int CONDITION = 4;
    private static final int BOUND = 10;

    @Override
    public boolean move() {
        return predicate(generateRandomNumber());
    }

    /**
     * 4 이상일 경우만 true
     *
     * @param number
     * @return
     */
    protected boolean predicate(int number) {
        return number >= CONDITION;
    }

    private int generateRandomNumber() {
        return new Random().nextInt(BOUND);
    }
}
