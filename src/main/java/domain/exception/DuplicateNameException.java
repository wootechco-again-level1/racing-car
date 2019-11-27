package domain.exception;

public class DuplicateNameException extends RuntimeException {
    private static final String MESSAGE = "중복된 이름이 존재합니다.";

    public DuplicateNameException() {
        super(MESSAGE);
    }
}
