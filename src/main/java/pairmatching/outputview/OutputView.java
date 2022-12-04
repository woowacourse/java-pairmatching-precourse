package pairmatching.outputview;

import java.util.Map;

@FunctionalInterface
public interface OutputView {
    void print(Map<String, Object> model);
}
