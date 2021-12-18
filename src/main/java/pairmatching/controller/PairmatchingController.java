package pairmatching.controller;

import pairmatching.domain.MenuSelect;
import pairmatching.view.InputView;

public class PairmatchingController {

    private final InputView inputView = new InputView();

    public void run() {
        MenuSelect menuSelect = inputView.requestMenuSelect();
        while (continueProgram(menuSelect)) {
            
        }
    }

    private boolean continueProgram(MenuSelect menuSelect) {
        return !menuSelect.isEnd();
    }
}
