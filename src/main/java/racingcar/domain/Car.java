package racingcar.domain;

import java.util.Objects;

public class Car {

    private static final int START_POSITION = 0;
    private static final int MOVE_DISTANCE = 1;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = START_POSITION;
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
}
