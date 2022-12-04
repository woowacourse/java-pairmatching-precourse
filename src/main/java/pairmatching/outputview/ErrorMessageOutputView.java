package pairmatching.outputview;

import java.util.Map;

public class ErrorMessageOutputView implements OutputView {
    @Override
    public void print(Map<String, Object> model) {
        String errorMessage = (String) model.get("errorMessage");
        System.out.printf("%s %s", "[ERROR]", errorMessage);
    }
}
