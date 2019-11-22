package racingcar;

import java.util.Objects;

public class Position {

    private static final int START_POSITION = 0;
    private static final int MOVE_DISTANCE = 1;

    private int position = START_POSITION;

    public int increase() {
        return position += MOVE_DISTANCE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
