package racingcar.view;

import racingcar.InputView;

import java.util.Scanner;

public class ConsoleInputView implements InputView {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String carNames() {
        String names;
        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
            names = scanner.nextLine();
        } while (InputValidator.validName(names));


        return names;
    }

    @Override
    public int numberOfRound() {
        String input;
        do {
            System.out.println("시도할 횟수는 몇회인가요?");
            input = scanner.nextLine();
        } while (InputValidator.validNumberOfRound(input));

        return Integer.parseInt(input);
    }
}
