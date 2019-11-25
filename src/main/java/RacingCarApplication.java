import domain.*;
import util.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class RacingCarApplication {
    public static void main(String[] args) {
        String nameInput = InputView.getNameInput();
        Cars cars = CarsCreator.createCars(nameInput);
        int numberOfRound = InputView.getNumberOfRound();

        RoundsResult roundsResult = RacingCarGame.play(cars, numberOfRound, new RandomNumberGenerator());
        OutputView.printRoundsResult(roundsResult);

        Winners winners = cars.getWinners();
        OutputView.printWinners(winners);
    }
}
