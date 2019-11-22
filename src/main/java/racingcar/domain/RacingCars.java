package racingcar.domain;

import racingcar.exception.RaceNotFinalException;

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
    private final RaceCount raceCount;
    private final Cars cars;

    public RacingCars(final Cars cars, final RaceCount raceCount) {
        this.raceCount = raceCount;
        this.cars = cars;
    }

    public RacingCars(final List<String> names, final RaceCount raceCount, final IntPredicate determineMovement) {
        this.raceCount = raceCount;
        this.cars = new Cars(names, determineMovement);
    }

    /**
     * 다음에 진행할 레이스가 남아 있는지 확인.
     *
     * @return boolean
     */
    public boolean hasNext() {
        return raceCount.isNotZero();
    }

    /**
     * 레이스를 진행.
     */
    public void race() {
        cars.race();
        raceCount.decrease();
    }

    /**
     * 가장 많이 움직인 자동차들을 구함.
     *
     * @return
     */
    public Cars generateFinalWinner() {
        validateRaceFinal();
        return cars.generateWinner();
    }

    private void validateRaceFinal() {
        if (hasNext()) {
            throw new RaceNotFinalException();
        }
    }

    public Cars getCars() {
        return cars;
    }
}
