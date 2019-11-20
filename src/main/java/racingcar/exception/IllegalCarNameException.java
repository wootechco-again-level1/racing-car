package racingcar.exception;

/**
 * Car 생성시 이름 규칙에 어긋났을 경우 발생하는 exception
 *
 * @author heebg
 * @version 1.0
 * @date 2019-11-20
 */
public class IllegalCarNameException extends RuntimeException {
    public IllegalCarNameException(String message) {
        super(message);
    }
}
