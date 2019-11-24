package racingcar.domain;

import org.apache.commons.lang3.StringUtils;
import racingcar.exception.CarValidateException;

import java.util.Objects;

public class Car {

    private static final int START_POSITION = 0;
    private static final int MOVE_DISTANCE = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String INVALID_NAME = "유효하지 않은 이름입니다.";
    private static final String OVER_LENGTH_NAME = "이름은 5자 이하만 가능합니다.";

    private final String name;
    private int position;

    public Car(String name) {
        this.name = validateName(name);
        this.position = START_POSITION;
    }

    private String validateName(String name) {
        if (StringUtils.isEmpty(name) || StringUtils.isBlank(name)) {
            throw new CarValidateException(INVALID_NAME);
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new CarValidateException(OVER_LENGTH_NAME);
        }

        return name;
    }

    public void move(boolean isMove) {
        if (isMove) {
            position += MOVE_DISTANCE;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean matchPosition(int position) {
        return this.position == position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
