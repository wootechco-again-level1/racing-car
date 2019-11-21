package racingcar.domain;

import java.util.List;
import java.util.function.IntPredicate;

/**
 * 자동차 경주 게임을 진행하는 객체
 *
 * @author heebg
 * @version 1.0
 * @date 2019-11-21
 */
public class RacingCars {
    private final PlayCount playCount;
    private final Cars cars;

    public RacingCars(final List<String> carNames, final int raceCount, final IntPredicate determineMovement) {
        this.playCount = new PlayCount(raceCount);
        this.cars = new Cars(carNames, raceCount, determineMovement);
    }

    public Cars getCars() {
        return cars;
    }

    /**
     * 다음에 진행할 레이스가 남아 있는지 확인.
     *
     * @return boolean
     */
    public boolean hasNext() {
        return playCount.isZero();
    }

    /**
     * 레이스를 진행.
     */
    public void race() {
        cars.race();
        playCount.decrease();
    }
}
