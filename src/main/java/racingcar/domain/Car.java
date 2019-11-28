package racingcar.domain;

import racingcar.exception.IllegalCarNameException;
import strategy.MoveStrategy;

import java.util.Objects;

/**
 * 레이스에 참여하는 자동차 객체
 *
 * @author heebg
 * @version 1.0
 * @date 2019-11-20
 */
public class Car {
    private static final int NAME_LENGTH_MAX = 5;
    private static final String NAME_LENGTH_MIN_EXCEPTION_MESSAGE = "자동차 이름은 1글자 이상이어야 합니다.";
    private static final String NAME_LENGTH_MAX_EXCEPTION_MESSAGE = "자동차 이름은 5자 미만이어야 합니다.";

    private final String name;
    private final ForwardCount forwardCount;
    private final MoveStrategy moveStrategy;

    public Car(final String name, final MoveStrategy moveStrategy) {
        validateName(name);
        this.name = name;
        this.forwardCount = new ForwardCount();
        this.moveStrategy = moveStrategy;
    }

    private void validateName(final String name) {
        if (Objects.isNull(name) || name.trim().isEmpty()) {
            throw new IllegalCarNameException(NAME_LENGTH_MIN_EXCEPTION_MESSAGE);
        }
        if (name.length() > NAME_LENGTH_MAX) {
            throw new IllegalCarNameException(NAME_LENGTH_MAX_EXCEPTION_MESSAGE);
        }
    }

    /**
     * 레이스 1회 실행.
     */
    public void race() {
        forwardCount.race(moveStrategy.move());
    }

    /**
     * 현재 이동한 길이가 같은지 확인.
     *
     * @param count
     * @return
     */
    public boolean isSameCount(int count) {
        return forwardCount.isSameCount(count);
    }

    public String getName() {
        return name;
    }

    public int getForwardCount() {
        return forwardCount.getCount();
    }

    @Override
    public String toString() {
        return "Car{" +
            "name='" + name + '\'' +
            ", forwardCount=" + forwardCount +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (!Objects.equals(name, car.name)) return false;
        return Objects.equals(forwardCount, car.forwardCount);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (forwardCount != null ? forwardCount.hashCode() : 0);
        return result;
    }
}
