package pairmatching.controller;

import pairmatching.model.crew.Course;
import pairmatching.model.crew.CrewPair;
import pairmatching.model.crew.Level;
import pairmatching.model.crew.Mission;
import pairmatching.model.matching.MatchingSystem;
import pairmatching.view.input.CrewNameInput;
import pairmatching.view.input.Function;
import pairmatching.view.input.InputView;
import pairmatching.view.input.OverWrite;
import pairmatching.view.output.OutputView;

import java.io.IOException;
import java.util.List;

public class PairMatchingController {
    private static final String BACKEND_FILE_PATH = "src/main/resources/backend-crew.md";
    private static final String FRONTEND_FILE_PATH = "src/main/resources/frontend-crew.md";
    private final InputView inputView;
    private final OutputView outputView;
    private final CrewNameInput crewNameInput;
    private boolean isWrongInput;
    private final MatchingSystem matchingSystem = new MatchingSystem();

    private Course course;
    private Level level;
    private Mission mission;

    public PairMatchingController(final InputView inputView, final OutputView outputView,
                                  final CrewNameInput crewNameInput) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.crewNameInput = crewNameInput;
    }

    public void run() {
        Function function = inputFunction();
        while (function != Function.QUIT) {
            if (function == Function.MATCHING) {
                match();
            } else if(function == Function.CHECK) {
                check();
            } else if(function == Function.RESET) {
                matchingSystem.reset();
            }
            function = inputFunction();
        }
    }

    private Function inputFunction() {
        isWrongInput = true;
        Function function = null;
        while (isWrongInput) {
            try {
                function = inputView.inputFunction();
                isWrongInput = false;
            } catch (Exception exception) {
                inputView.showErrorMessage(exception.getMessage());
            }
        }
        return function;
    }


    private void match() {
        inputCourseAndLevelAndMission();
        if (matchingSystem.isMatchedBefore(course, level, mission)) {
            overWriteIfUserInputYes();
        } else if (!matchingSystem.isMatchedBefore(course, level, mission)) {
            matchNew();
        }
    }

    private void overWriteIfUserInputYes() {
        if (inputOverWrite() == OverWrite.YES) {
            matchNew();
        }
    }

    private void matchNew() {
        isWrongInput = true;
        List<String> crewNames = null;
        while(isWrongInput) {
            try{
                crewNames = readCrewNames(course);
                isWrongInput = false;
            } catch (Exception exception) {
                inputView.showErrorMessage(exception.getMessage());
            }
        }
        matchingSystem.match(crewNames, course, level, mission);
        outputView.showMatchedCrews(matchingSystem.getMatchingHistoryOf(course, level, mission));
    }

    private List<String> readCrewNames(Course course) throws IOException {
        if(course == Course.BACKEND) {
            return crewNameInput.readNames(BACKEND_FILE_PATH);
        }
        return crewNameInput.readNames(FRONTEND_FILE_PATH);
    }

    private OverWrite inputOverWrite() {
        isWrongInput = true;
        OverWrite overWrite = null;
        while (isWrongInput) {
            try {
                overWrite = inputView.inputOverWrite();
                isWrongInput = false;
            } catch (Exception exception) {
                inputView.showErrorMessage(exception.getMessage());
            }
        }
        return overWrite;
    }

    private void inputCourseAndLevelAndMission() {
        isWrongInput = true;
        while(isWrongInput) {
            List<String> courseAndLevelAndMission = inputView.inputCourseAndMission();
            try{
                course = Course.of(courseAndLevelAndMission.get(0));
                level = Level.of(courseAndLevelAndMission.get(1));
                mission = Mission.of(courseAndLevelAndMission.get(1), courseAndLevelAndMission.get(2));
                isWrongInput = false;
            } catch (Exception exception) {
                inputView.showErrorMessage(exception.getMessage());
            }
        }
    }

    private void check() {
        inputCourseAndLevelAndMission();
        List<CrewPair> names = matchingSystem.getMatchingHistoryOf(course, level, mission);
        outputView.showMatchedCrews(names);
    }
}
