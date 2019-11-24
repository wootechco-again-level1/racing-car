package domain;

import exception.InvalidNameException;
import util.NumberGenerator;

public class Car {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int FORWARD_CONDITION = 4;

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    private void validateName(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new InvalidNameException("이름은 1~5자만 가능합니다.");
        }
    }

    public void race(NumberGenerator numberGenerator) {
        if (numberGenerator.generateNumber() >= FORWARD_CONDITION) {
            this.position++;
        }
    }

    public boolean isWinner(int maxPosition) {
        return this.position == maxPosition;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
