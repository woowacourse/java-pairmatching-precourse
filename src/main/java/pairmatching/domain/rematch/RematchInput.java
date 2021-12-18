package pairmatching.domain.rematch;

public class RematchInput {
    public static final String NON_EXIST_OPTION_EXCEPTION = "[ERROR] 네 또는 아니오를 입력해주세요";
    public static final String YES_OPTION = "네";
    public static final String NO_OPTION = "아니오";
    private String answer;

    public RematchInput(String answer) {
        validateRematchInput(answer);
        this.answer = answer;
    }

    private void validateRematchInput(String answer) {
        if (!YES_OPTION.equals(answer) && !NO_OPTION.equals(answer)) {
            throw new IllegalArgumentException(NON_EXIST_OPTION_EXCEPTION);
        }
    }

    public boolean noRematch() {
        return NO_OPTION.equals(answer);
    }
}
