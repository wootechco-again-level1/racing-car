package racingcar.view;

import racingcar.InputView;

import java.util.Scanner;

public class ConsoleInputView implements InputView {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String inputCarNames() {
        String names;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        do {
            names = scanner.nextLine();
        } while (InputValidator.invalidName(names));

        return names;
    }

    @Override
    public int inputNumberOfRound() {
        String input;
        do {
            System.out.println("시도할 횟수는 몇회인가요?");
            input = scanner.nextLine();
        } while (InputValidator.invalidNumberOfRound(input));

        return Integer.parseInt(input);
    }
}
