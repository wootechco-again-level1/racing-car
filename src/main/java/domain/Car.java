package domain;

import domain.exception.InvalidCarNameLengthException;

import java.util.Objects;

public class Car {
    private static final int CAR_NAME_LENGTH_SIZE = 5;

    private final String name;
    private final int position;

    public Car(final String name, final int position) {
        checkCarNameLength(name);
        this.name = name;
        this.position = position;
    }

    private void checkCarNameLength(final String name) {
        if (name.length() > CAR_NAME_LENGTH_SIZE) {
            throw new InvalidCarNameLengthException();
        }
    }

    public Car move(final MoveStrategy moveStrategy) {
        if (moveStrategy.move()) {
            return new Car(name, position + 1);
        }

        return this;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "Car{" + "name='" + name + '\'' + ", position=" + position + '}';
    }
}
