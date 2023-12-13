package pairmatching.view;

import static pairmatching.view.ViewMessage.*;

public class OutputView {

    public void printException(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public void printSelectOption() {
        System.out.printf(SELECT_OPTION.getMessage());
    }

    public void printSelectInfo() {
        System.out.printf(INFO.getMessage());
    }

    public void printRematching() {
        System.out.printf(REMATCHING.getMessage());
    }
}
