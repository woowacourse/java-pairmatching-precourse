package pairmatching.view;

import java.util.List;

public interface InputView {
    void showErrorMessage(final String errorMessage);

    Function inputFunction();

    List<String> inputCourseAndMission();
}
