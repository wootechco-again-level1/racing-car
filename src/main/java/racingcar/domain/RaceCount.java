package racingcar.domain;

import racingcar.exception.IllegalRaceCountException;

/**
 * 레이스 횟수를 나타낸 객체
 *
 * @author heebg
 * @version 1.0
 * @date 2019-11-20
 */
public class RaceCount {
    private static final int INIT_COUNT = 0;
    private static final int DIFF_INIT_TO_RACE_COUNT = 1;
    private static final String COUNT_EXCEPTION_MESSAGE = "카운트는 " + (INIT_COUNT + DIFF_INIT_TO_RACE_COUNT) + "이상이어야 합니다.";
    private static final String COUNT_DECREASE_EXCEPTION_MESSAGE = INIT_COUNT + "보다 작아지면 안됩니다.";

    private int count;

    public RaceCount() {
        this.count = INIT_COUNT;
    }

    public RaceCount(final int count) {
        validateCount(count);
        this.count = count;
    }

    private void validateCount(final int count) {
        if (count < INIT_COUNT + DIFF_INIT_TO_RACE_COUNT) {
            throw new IllegalRaceCountException(COUNT_EXCEPTION_MESSAGE);
        }
    }

    /**
     * count값을 1 증가시킨다.
     */
    public void increase() {
        count++;
    }

    /**
     * count값을 1 감소시킨다. <br/>
     * 만약 초기값보다 작다면 에러 발생.
     */
    public void decrease() {
        validateDecrease();
        count--;
    }

    private void validateDecrease() {
        if (isZero()) {
            throw new IllegalRaceCountException(COUNT_DECREASE_EXCEPTION_MESSAGE);
        }
    }

    /**
     * count값이 0인지 확인
     *
     * @return boolean
     */
    public boolean isZero() {
        return count == 0;
    }

    public int getCount() {
        return count;
    }
}
