package racingcar.controller;

public class RandomMove implements MoveStrategy {

    private static final int RANDOM_NUMBER_RANGE = 10;
    private static final int MOVE_CONDITION = 4;

    @Override
    public boolean isMove() {
        return (int) (Math.random() * RANDOM_NUMBER_RANGE) >= MOVE_CONDITION;
    }
}
