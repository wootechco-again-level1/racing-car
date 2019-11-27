package presentation;

import application.CarsGenerator;
import domain.Cars;
import domain.RandomMoveStrategy;
import domain.Winner;
import view.InputView;
import view.OutputView;

public class Game {
    public static void play() {
        String name = InputView.inputNames();
        int count = InputView.inputCount();

        Cars cars = CarsGenerator.generate(name);
        Winner winner = new Winner(cars, count);

        while (winner.hasNotWinner()) {
            cars = cars.move(new RandomMoveStrategy());
            OutputView.printCars(cars);
            winner = new Winner(cars, count);
        }

        OutputView.printWinner(winner);
    }
}
