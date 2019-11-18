package racingcar.domain;

public class Car {
    private final String name;
    private int distance = 0;

    public Car(String name) {
        CarValidator.validCarLength(name);
        this.name = name;
    }

    public int move(int movable) {
        if (movable >= 4) {
            distance += 1;
        }

        return distance;
    }
}
