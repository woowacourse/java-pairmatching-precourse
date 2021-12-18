package pairmatching.view;

public interface InputView {
    void showErrorMessage(final String errorMessage);

    Function inputFunction();
}
