package domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MOVE_CONDITION = 4;
    private static final int MOVE_BOUND = 10;
    private static final Random random = new Random();

    @Override
    public boolean move() {
        return random.nextInt(MOVE_BOUND) <= MOVE_CONDITION;
    }
}
