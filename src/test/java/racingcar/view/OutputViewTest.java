package racingcar.view;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-23
 */
class OutputViewTest {
    @Test
    void outputProcess() {
        Map<String, Integer> data = new LinkedHashMap<>();
        data.put("hee", 1);
        data.put("bong", 2);

        OutputView.outputProcess(data);
    }

    @Test
    void outputWinner() {
        List<String> data = Arrays.asList("hee", "bong");
        OutputView.outputWinner(data);
    }
}