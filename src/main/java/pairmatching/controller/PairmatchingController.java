package pairmatching.controller;

import pairmatching.domain.crew.Crews;
import pairmatching.domain.matchingcondition.MatchingCondition;
import pairmatching.domain.menu.Menu;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairmatchingController {

    private Crews backendCrews = new Crews();
    private Crews frontendCrews = new Crews();

    public void run() {
        backendCrews = InputView.requestBackendCrews();
        frontendCrews = InputView.requestFrontendCrews();

        Menu menu = InputView.requestMenuSelect();
        while (continueProgram(menu)) {
            executeMenu(menu);
        }
    }

    private boolean continueProgram(Menu menu) {
        return !menu.isEnd();
    }

    private void executeMenu(Menu menu) {
        if (menu.isMatchingPair()) {
            executePairMatching();
        }
        if (menu.isReadPair()) {
            executeReadPair();
        }
        if (menu.isInitializePair()) {
            executeInitializePair();
        }
    }

    private void executePairMatching() {
        OutputView.showCoursesAndMissions();
        MatchingCondition matchingCondition = InputView.requestMatchingCondition();
    }

    private void executeReadPair() {
    }

    private void executeInitializePair() {
    }
}
