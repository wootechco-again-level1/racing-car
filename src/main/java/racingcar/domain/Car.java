package racingcar.domain;

public class Car {
    private static final int MIN_MOVABLE_NUMBER = 4;
    private static final int MOVE = 1;
    private static final int STOP = 0;

    private final String name;
    private int distance;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int distance) {
        CarValidator.validCarLength(name);

        this.name = name;
        this.distance = distance;
    }

    public int move(int movable) {
        distance += checkMovable(movable);
        return distance;
    }

    private int checkMovable(int movable) {
        return movable >= MIN_MOVABLE_NUMBER ? MOVE : STOP;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
