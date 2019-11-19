package racingcar.domain;

import java.util.Objects;

public class MovedCar {
    private final String name;
    private final int distance;

    public MovedCar(Car car) {
        this(car.getName(), car.getDistance());
    }

    public MovedCar(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public boolean isWinner(int maxDistance) {
        return distance == maxDistance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovedCar movedCar = (MovedCar) o;
        return distance == movedCar.distance &&
                Objects.equals(name, movedCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }
}
