package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public static int inputCount() {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("정수인 숫자를 입력해주세요.");
            scanner.nextLine();
            return inputCount();
        }
    }
}
