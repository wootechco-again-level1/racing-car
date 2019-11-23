package domain.exception;

public class InvalidCarNameLengthException extends RuntimeException {
    private static final String MESSAGE = "자동차 이름은 5자리 이하만 가능합니다.";

    public InvalidCarNameLengthException() {
        super(MESSAGE);
    }
}
