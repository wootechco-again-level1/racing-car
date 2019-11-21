package racingcar.exception;

/**
 * 우승차가 없을 경우 발생하는 exception.
 *
 * @author heebg
 * @version 1.0
 * @date 2019-11-21
 */
public class WinnerNotFoundException extends RuntimeException {
    public WinnerNotFoundException() {
        super();
    }
}
