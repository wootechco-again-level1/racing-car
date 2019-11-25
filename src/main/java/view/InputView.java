package view;

import exception.InvalidNameException;
import exception.InvalidNumberOfRoundException;

import java.util.Scanner;

public class InputView {
    private static final int MIN_NUMBER_OF_ROUND = 1;
    private static final int MIN_NUMBER_OF_CAR = 2;
    private static final String DELIMITER = ",";
    private static final String NAME_REGEX = "[가-힣a-zA-Z,]+";

    private static final Scanner scanner = new Scanner(System.in);

    public static String getNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분하며, 1~5자만 가능합니다).");
        try {
            return validateNameInput(scanner.nextLine());
        } catch (InvalidNameException e) {
            System.err.println(e.getMessage());
            return getNameInput();
        }
    }

    public static int getNumberOfRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            return validateNumberOfRoundInput(Integer.parseInt(scanner.nextLine()));
        } catch (NumberFormatException e) {
            System.err.println("숫자만 입력 가능합니다.");
            return getNumberOfRound();
        } catch (InvalidNumberOfRoundException e) {
            System.err.println(e.getMessage());
            return getNumberOfRound();
        }
    }

    private static String validateNameInput(String nameInput) {
        if (!nameInput.matches(NAME_REGEX)) {
            throw new InvalidNameException("이름으로는 한글, 영어만 사용 가능합니다.");
        }
        if (nameInput.split(DELIMITER).length < MIN_NUMBER_OF_CAR) {
            throw new InvalidNameException("둘 이상의 이름을 입력하세요.");
        }
        return nameInput;
    }

    private static int validateNumberOfRoundInput(int numberOfRound) {
        if (numberOfRound < MIN_NUMBER_OF_ROUND) {
            throw new InvalidNumberOfRoundException("1 이상의 적절한 숫자를 입력하세요.");
        }
        return numberOfRound;
    }
}
