package racingcar.domain.exception;

public class InvalidCarNameLengthException extends RuntimeException {
    private static String ERROR_MESSAGE = "차 이름이 5자를 넘으면 안됩니다.";

    public InvalidCarNameLengthException() {
        super(ERROR_MESSAGE);
    }
}
