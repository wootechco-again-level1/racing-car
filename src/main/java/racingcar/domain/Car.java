package racingcar.domain;

import java.util.Objects;

public class Car {

    private final String name;
    private Position position;

    public Car(String name) {
        this.name = name;
        this.position = new Position();
    }

    public void move(boolean isMove) {
        if (isMove) {
            position.increase();
        }
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
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
