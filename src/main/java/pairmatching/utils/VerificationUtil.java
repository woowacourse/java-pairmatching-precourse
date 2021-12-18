package pairmatching.utils;

public class VerificationUtil {

    private VerificationUtil() {
    }

    public static void validateFunctionChoice(String input) {
        if (input.equals("1") || input.equals("2") || input.equals("3")
                || input.equals("Q")) {
            return;
        }

        throw new IllegalArgumentException("[ERROR] 올바르지 않은 기능 선택 입력입니다.");
    }

    public static void validateExistPairInput(String input) {
        if (input.equals("네") || input.equals("아니오")) {
            return;
        }

        throw new IllegalArgumentException("[ERROR] 올바르지 않은 입력입니다.");
    }
}
