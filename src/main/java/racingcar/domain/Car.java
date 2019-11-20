package racingcar.domain;

import racingcar.exception.IllegalCarNameException;

import java.util.Objects;
import java.util.Random;
import java.util.function.IntPredicate;

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
    private final IntPredicate determinationMovement;

    public Car(final String name, PlayRaceCount playRaceCount, IntPredicate determinationMovement) {
        validateName(name);
        this.name = name;
        this.playRaceCount = playRaceCount;
        this.forwardCount = new ForwardRaceCount();
        this.determinationMovement = determinationMovement;
    }

    private void validateName(final String name) {
        if (Objects.isNull(name) || name.trim().isEmpty()) {
            throw new IllegalCarNameException(NAME_LENGTH_MIN_EXCEPTION_MESSAGE);
        }
        if (name.length() > NAME_LENGTH_MAX) {
            throw new IllegalCarNameException(NAME_LENGTH_MAX_EXCEPTION_MESSAGE);
        }
    }

    /**
     * 레이스 1회 실행.
     */
    public void play() {
        move(getRandomNumber());
    }

    /**
     * determinationMovement를 실행해서 결과에 따라 forwardCount값 증가. <br/>
     * playRaceCount값 감소.
     *
     * @param number determinationMovement에 전달할 인자.
     */
    public void move(int number) {
        if (determinationMovement.test(number)) {
            forwardCount.increase();
        }
        playRaceCount.decrease();
    }

    private int getRandomNumber() {
        return new Random().nextInt(10);
    }

    public String getName() {
        return name;
    }

    public int getForwardCount() {
        return forwardCount.getCount();
    }
}
