package racingcar.view;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.IntStream;

/**
 * 사용자에게 보여주는 뷰
 *
 * @author heebg
 * @version 1.0
 * @date 2019-11-23
 */
public class OutputView {
    public static void outputProcessTitle() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void outputProcess(Map<String, Integer> data) {
        data.forEach((key, value) -> {
            String output = key + " : " + getValue(value);
            System.out.println(output);
        });
        System.out.println();
    }

    private static String getValue(int value) {
        String icon = "-";
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, value).forEach(index -> stringBuilder.append(icon));
        return stringBuilder.toString();
    }

    public static void outputWinner(List<String> winners) {
        StringJoiner stringJoiner = new StringJoiner(", ");
        winners.forEach(stringJoiner::add);
        System.out.println(stringJoiner.toString() + "가 최종 우승했습니다.");
    }
}
