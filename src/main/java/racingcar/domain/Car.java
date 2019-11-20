package racingcar.domain;

import racingcar.exception.IllegalCarNameException;

import java.util.Objects;

/**
 * 레이스에 참여하는 자동차 객체
 *
 * @author heebg
 * @version 1.0
 * @date 2019-11-20
 */
public class Car {
    private static final int NAME_LENGTH_MAX = 5;
    private static final String NAME_LENGTH_MIN_EXCEPTION_MESSAGE = "자동차 이름은 1글자 이상이어야 합니다.";
    private static final String NAME_LENGTH_MAX_EXCEPTION_MESSAGE = "자동차 이름은 5자 미만이어야 합니다.";

    private final String name;
    private final PlayRaceCount playRaceCount;
    private final ForwardRaceCount forwardCount;

    public Car(final String name, PlayRaceCount playRaceCount) {
        validateName(name);
        this.name = name;
        this.playRaceCount = playRaceCount;
        this.forwardCount = new ForwardRaceCount();
    }

    private void validateName(final String name) {
        if (Objects.isNull(name) || name.trim().isEmpty()) {
            throw new IllegalCarNameException(NAME_LENGTH_MIN_EXCEPTION_MESSAGE);
        }
        if (name.length() > NAME_LENGTH_MAX) {
            throw new IllegalCarNameException(NAME_LENGTH_MAX_EXCEPTION_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }
}
