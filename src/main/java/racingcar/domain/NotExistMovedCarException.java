package racingcar.domain;

public class NotExistMovedCarException extends RuntimeException {
    private static final String ERROR_MESSAGE = "멀리 못갔습니다.";

    public NotExistMovedCarException() {
        super(ERROR_MESSAGE);
    }
}
