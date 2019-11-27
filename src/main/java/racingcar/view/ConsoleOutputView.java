package racingcar.view;

import racingcar.OutputView;
import racingcar.domain.*;

import java.util.List;

public class ConsoleOutputView implements OutputView {
    private static final String WINNER_DELIMITER = " ";
    private static final String DISTANCE_EXPRESSION = "-";

    @Override
    public void roundResults(RoundResults roundResults) {
        List<RoundResult> allRoundResult = roundResults.getAllRoundResult();

        for (RoundResult roundResult : allRoundResult) {
            printRoundResultOfMovedCars(roundResult.getMovedCars());
        }
    }

    private void printRoundResultOfMovedCars(List<MovedCar> movedCars) {
        System.out.println("실행결과");
        System.out.println("------");

        movedCars.stream()
                .map(this::convertMovedCarToRoundResultFormat)
                .forEach(System.out::println);

        System.out.println();
    }

    private String convertMovedCarToRoundResultFormat(MovedCar movedCar) {
        return String.format("%s: %s", movedCar.getName(), expressDistance(movedCar.getDistance()));
    }

    private String expressDistance(int distance) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < distance; i++) {
            stringBuilder.append(DISTANCE_EXPRESSION);
        }

        return stringBuilder.toString();
    }

    @Override
    public void gameResult(GameResult gameResult) {
        System.out.println(convertMovedCarToWinnerFormat(gameResult.calculateGameWinner()));
    }

    private String convertMovedCarToWinnerFormat(Winner winner) {
        return String.format("우승자는 %s입니다.", expressWinner(winner));
    }

    private String expressWinner(Winner winner) {
        StringBuilder stringBuilder = new StringBuilder();
        List<MovedCar> movedCars = winner.get();

        for (MovedCar movedCar : movedCars) {
            stringBuilder.append(movedCar.getName()).append(WINNER_DELIMITER);
        }

        return stringBuilder.toString();
    }
}
