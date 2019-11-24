package racingcar.view;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    public static void printWinners(List<String> winnerNames) {
        StringJoiner stringJoiner = new StringJoiner(", ");
        winnerNames.forEach(stringJoiner::add);
        System.out.println(stringJoiner.toString() + " 가 우승했습니다.");
    }
}
