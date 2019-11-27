package utils;

public class InputUtils {
    private static final String COMMA = ",";
    private static final String BLANK = " ";
    private static final String EMPTY = "";

    public static String[] splitWithCommaAndRemoveBlank(final String text) {
        return splitWithComma(removeBlank(text));
    }

    private static String[] splitWithComma(final String text) {
        return text.split(COMMA);
    }

    private static String removeBlank(final String text) {
        return text.replace(BLANK, EMPTY);
    }
}
