package racingcar.service;

import java.util.Random;

public class RandomMove implements MoveStrategy {

    private static final int RANDOM_NUMBER_RANGE = 10;
    private static final int MOVE_CONDITION = 4;

    @Override
    public boolean isMove() {
        int randomNumber = new Random().nextInt(RANDOM_NUMBER_RANGE);
        return randomNumber >= MOVE_CONDITION;
    }
}
