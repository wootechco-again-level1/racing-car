package domain;

import java.util.Objects;

public class Car {
    private final String name;
    private final int position;

    public Car(final String name, final int position) {
        this.name = name;
        this.position = position;
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
