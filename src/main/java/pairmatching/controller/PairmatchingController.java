package pairmatching.controller;

import java.util.List;

import pairmatching.domain.course.enums.CourseEnum;
import pairmatching.domain.crew.Crew;
import pairmatching.domain.crew.Crews;
import pairmatching.domain.matching.MatchingCondition;
import pairmatching.domain.matching.MatchingResult;
import pairmatching.domain.matching.MatchingResults;
import pairmatching.domain.menu.Menu;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairmatchingController {

    private Crews crews = new Crews();
    private MatchingResults matchingResults = new MatchingResults();

    public void run() {
        loadCrews();
        Menu menu = InputView.requestMenuSelect();
        while (continueProgram(menu)) {
            executeMenu(menu);
            menu = InputView.requestMenuSelect();
        }
    }

    private void loadCrews() {
        crews.add(CourseEnum.BACKEND, InputView.requestBackendCrews());
        crews.add(CourseEnum.FRONTEND, InputView.requestFrontendCrews());
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
        crews.match(matchingCondition);
    }

    private void executeReadPair() {
    }

    private void executeInitializePair() {
    }
}
