package racingcar.view;

import java.util.Scanner;

/**
 * 사용자로부터 입력받는 뷰
 *
 * @author heebg
 * @version 1.0
 * @date 2019-11-23
 */
public class InputView {
    public static String inputNames(Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public static int inputRaceCount(Scanner scanner) {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }
}
