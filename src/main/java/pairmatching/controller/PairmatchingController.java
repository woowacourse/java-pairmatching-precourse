package pairmatching.controller;

import pairmatching.domain.course.enums.CourseEnum;
import pairmatching.domain.crew.Crews;
import pairmatching.domain.matching.MatchingCondition;
import pairmatching.domain.matching.MatchingResults;
import pairmatching.domain.menu.Menu;
import pairmatching.domain.pair.Pairs;
import pairmatching.domain.rematch.RematchInput;
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
        if (matchingResults.cotains(matchingCondition)) {
            RematchInput answer = InputView.requestRematch();
            if (answer.noRematch()) {
                return;
            }
        }
        Pairs pairs = crews.getMatchResult(matchingCondition);
        OutputView.showPairs(pairs);
        matchingResults.add(matchingCondition, pairs);
    }

    private void executeReadPair() {
        OutputView.showCoursesAndMissions();
        MatchingCondition matchingCondition = InputView.requestMatchingCondition();
        OutputView.showExistPairs(matchingResults, matchingCondition);
    }

    private void executeInitializePair() {
        matchingResults.initialize();
    }
}
