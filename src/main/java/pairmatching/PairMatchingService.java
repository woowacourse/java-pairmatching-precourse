package pairmatching;

public class PairMatchingService {
    public static String getValidateMenu(String input) {
        validateMenu(input);
        return input;
    }

    private static void validateMenu(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException("메뉴에 없는 기능입니다.");
        }
        if (!"123Q".contains(input)) {
            throw new IllegalArgumentException("메뉴에 없는 기능입니다.");
        }
    }
}
