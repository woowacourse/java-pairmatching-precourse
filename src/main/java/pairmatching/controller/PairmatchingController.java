package pairmatching.controller;

import pairmatching.domain.crew.Crews;
import pairmatching.domain.menu.Menu;
import pairmatching.view.InputView;

public class PairmatchingController {

    private final InputView inputView = new InputView();

    public void run() {
        Crews backendCrews = inputView.requestBackendCrews();
        Crews frontendCrews = inputView.requestFrontendCrews();

        Menu menuSelect = inputView.requestMenuSelect();
        while (continueProgram(menuSelect)) {

        }
    }

    private boolean continueProgram(Menu menuSelect) {
        return !menuSelect.isEnd();
    }
}
