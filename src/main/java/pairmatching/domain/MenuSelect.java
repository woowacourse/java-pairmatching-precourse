package pairmatching.domain;

public class MenuSelect {
    public static final String OPTION_ONE = "1";
    public static final String OPTION_TWO = "2";
    public static final String OPTION_THREE = "3";
    public static final String OPTION_QUIT = "4";

    private String input;

    public MenuSelect(String input) {
        validateMenuSelect();
        this.input = input;
    }

    public boolean isEnd() {
        return OPTION_QUIT.equals(input);
    }

    private void validateMenuSelect() {
        if (OPTION_ONE.equals(input) || OPTION_TWO.equals(input) ||
            OPTION_THREE.equals(input) || OPTION_QUIT.equals(input)) {
            return;
        }
        throw new IllegalArgumentException("1, 2, 3, Q 중 하나를 선택해주세요");
    }
}
