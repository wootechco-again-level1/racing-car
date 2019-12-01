package domain;

import exception.InvalidNameException;
import org.apache.commons.lang3.StringUtils;
import util.NumberGenerator;

public class Car {
    private static final int STARTING_POSITION = 0;
    private static final int FORWARD_CONDITION = 4;
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = STARTING_POSITION;
    }

    private void validateName(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH
                || StringUtils.isBlank(name)) {
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
