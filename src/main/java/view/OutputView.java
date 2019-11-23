package view;

import domain.Car;
import domain.Cars;
import domain.Winner;

import java.util.stream.Collectors;

public class OutputView {
    private static final StringBuilder stringBuilder = new StringBuilder();

    public static void printCars(final Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + printPosition(car));
        }
        printNewLine();
    }

    private static void printNewLine() {
        System.out.println();
    }

    private static String printPosition(final Car car) {
        stringBuilder.setLength(0);

        for (int i = 0; i < car.getPosition(); i++) {
            stringBuilder.append("-");
        }

        return stringBuilder.toString();
    }

    public static void printWinner(final Winner winner) {
        String text = winner.findWinner().getCars().stream()
                .map(Car::getName)
                .collect(Collectors.joining(","));

        System.out.println(text + "가 최종 우승했습니다.");
    }
}
