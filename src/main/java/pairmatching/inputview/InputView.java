package pairmatching.inputview;

import java.util.Map;

@FunctionalInterface
public interface InputView<E> {
    E getInput(Map<String, Object> model);
}
