package pairmatching.view;

public class InputView {
    public static String[] splitString(String input) {
        String[] result = input.split(",");
        isValidPairMatching(result);
        return result;
    }

    private static void isValidPairMatching(String[] result) {

    }

    public static String  isValidSelect(String input) {
        if (!(input.equals("1") || input.equals("2") || input.equals("3") || input.equals("Q"))) {
            throw new IllegalArgumentException();
        }
        return input;
    }
}