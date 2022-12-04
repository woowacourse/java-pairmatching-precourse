package pairmatching.outputview;

import java.util.Map;

public class ResetOutputView implements OutputView {

    public static final String RESET_COMPLETED_MESSAGE = "초기화 되었습니다.";

    @Override
    public void print(Map<String, Object> model) {
        System.out.println(RESET_COMPLETED_MESSAGE);
    }
}
