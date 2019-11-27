package racingcar.domain.exception;

public class NotExistMovedCarException extends RuntimeException {
    private static final String ERROR_MESSAGE = "경주한 차가 존재하지 않습니다.";

    public NotExistMovedCarException() {
        super(ERROR_MESSAGE);
    }
}
