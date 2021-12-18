package pairmatching.validation;

public class MenuValidation {

    public static void isValidMenu(String input) {
        if (isExit(input) || (isInteger(input)) && isValidInteger(Integer.parseInt(input))) {
            return;
        }
        throw new IllegalArgumentException("1,2,3,Q 중 하나의 값을 입력해주세요.");
    }

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean isValidInteger(int i) {
        return (i == 1) || (i == 2) || (i == 3);
    }

    public static boolean isExit(String input) {
        return input.equals("Q");
    }
}
