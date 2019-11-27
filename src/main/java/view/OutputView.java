package view;

import domain.OneRound;
import domain.RoundsResult;
import domain.Winners;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String DELIMITER = ", ";
    private static final String HYPHEN = "-";
    private static final int ZERO = 0;

    public static void printRoundsResult(RoundsResult roundsResult) {
        List<OneRound> rounds = roundsResult.getRounds();
        System.out.println("\n실행 결과");
        for (OneRound round : rounds) {
            printOneRound(round);
        }
    }

    private static void printOneRound(OneRound oneRound) {
        Map<String, Integer> carStatuses = oneRound.getCarStatuses();
        for (String name : carStatuses.keySet()) {
            System.out.println(name + " : " + visualizePosition(carStatuses.get(name)));
        }
        System.out.println();
    }

    private static String visualizePosition(int position) {
        StringBuilder result = new StringBuilder();
        while (position-- > ZERO) {
            result.append(HYPHEN);
        }
        return result.toString();
    }

    public static void printWinners(Winners winners) {
        List<String> names = winners.getWinnersName();
        String joinedNames = String.join(DELIMITER, names);
        System.out.println(joinedNames + "가 최종 우승했습니다.");
    }
}
