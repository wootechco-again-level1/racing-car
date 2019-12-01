package racingcar.view;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.IntStream;

public class OutputView {

    private static final String NEXT_LINE = "\n";
    private static final String KEY_VALUE_DELIMITER = " : ";
    private static final String WINNER_PRINT_DELIMITER = ", ";
    private static final String VALUE_SYMBOL = "-";

    private static StringBuilder stringBuilder = new StringBuilder();

    public static void printResultIntro() {
        System.out.println(NEXT_LINE + "실행 결과");
    }

    public static void printRoundResult(Map<String, Integer> positions) {
        positions.forEach((key, value) -> {
            stringBuilder.append(key);
            stringBuilder.append(KEY_VALUE_DELIMITER);
            IntStream.rangeClosed(1, value).forEach(i -> stringBuilder.append(VALUE_SYMBOL));
            stringBuilder.append(NEXT_LINE);
        });

        System.out.println(stringBuilder.toString());
        stringBuilder.setLength(0);
    }

    public static void printWinners(List<String> winnerNames) {
        StringJoiner stringJoiner = new StringJoiner(WINNER_PRINT_DELIMITER);
        winnerNames.forEach(stringJoiner::add);
        System.out.println(stringJoiner.toString() + " 가 우승했습니다.");
    }
}
