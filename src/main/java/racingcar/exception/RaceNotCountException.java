package racingcar.exception;

/**
 * RaceCount 생성시 규칙에 어긋났을 경우 발생하는 exception
 *
 * @author heebg
 * @version 1.0
 * @date 2019-11-20
 */
public class RaceNotCountException extends RuntimeException {
    public RaceNotCountException(String message) {
        super(message);
    }
}
