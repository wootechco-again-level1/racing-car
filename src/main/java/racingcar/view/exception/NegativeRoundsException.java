package racingcar.view.exception;

public class NegativeRoundsException extends RuntimeException {
    private static final String ERROR_MESSAGE = "음수인 라운드 횟수는 허용되지 않습니다.";

    public NegativeRoundsException() {
        super(ERROR_MESSAGE);
    }
}
