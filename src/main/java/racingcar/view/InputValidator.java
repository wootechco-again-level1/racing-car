package racingcar.view;

import racingcar.view.exception.NegativeRoundsException;

import java.util.regex.Pattern;

class InputValidator {
    private static final Pattern namesRegex = Pattern.compile("([a-zA-Z가-힣]{1,5})(,[a-zA-Z가-힣]{1,5})*");
    private static final int MIN_VALID_ROUND = 1;

    static boolean invalidName(String names) {
        return invalidName(!namesRegex.matcher(names).matches());
    }

    private static boolean invalidName(boolean isInvalid) {
        if (isInvalid) {
            System.err.println("자동차 이름 입력이 잘못되었습니다. 다시 입력해주세요.(이름은 쉼표(,) 기준으로 구분)");
        }

        return isInvalid;
    }

    static boolean invalidNumberOfRound(String numberOfRound) {
        try {
            int rounds = Integer.parseInt(numberOfRound);
            validNegativeNumber(rounds);
            return false;
        } catch (NumberFormatException | NegativeRoundsException e) {
            System.err.println("횟수는 0 이상의 숫자만 입력가능합니다.");
            return true;
        }
    }

    private static void validNegativeNumber(int rounds) {
        if (rounds < MIN_VALID_ROUND) {
            throw new NegativeRoundsException();
        }
    }
}