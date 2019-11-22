package racingcar.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-23
 */
class InputViewTest {
    private Scanner scanner;

    @Test
    void inputNames() {
        String target = "heebg, hi, by";
        scanner = getScanner(target.getBytes());
        String source = InputView.inputNames(scanner);
        assertEquals(source, target);
    }

    @Test
    void inputRaceCount() {
        String target = "5";
        scanner = getScanner(target.getBytes());
        int source = InputView.inputRaceCount(scanner);
        assertEquals(Integer.parseInt(target), source);
    }

    private Scanner getScanner(byte[] data) {
        System.setIn(new ByteArrayInputStream(data));
        return new Scanner(System.in);
    }
}