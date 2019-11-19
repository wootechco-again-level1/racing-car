package racingcar.view;

import racingcar.view.exception.NegativeRoundsException;

import java.util.regex.Pattern;

class InputValidator {
    private static final Pattern namesRegex = Pattern.compile("([a-zA-Z가-힣]{1,5})(,[a-zA-Z가-힣]{1,5})*");

    static boolean validName(String names) {
        return !namesRegex.matcher(names).matches();
    }

    static boolean validNumberOfRound(String numberOfRound) {
        try {
            int rounds = Integer.parseInt(numberOfRound);
            validNegativeNumber(rounds);
            return false;
        } catch (NumberFormatException | NegativeRoundsException e) {
            System.out.println("횟수는 0 이상의 숫자만 입력가능합니다.");
            return true;
        }
    }

    private static void validNegativeNumber(int rounds) {
        if (rounds < 0) {
            throw new NegativeRoundsException();
        }
    }
}