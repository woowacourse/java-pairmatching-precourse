package pairmatching.Service;

import pairmatching.Controller.MatchingController;
import pairmatching.Model.*;
import pairmatching.View.InputView;
import pairmatching.View.OutputView;

import java.util.Arrays;
import java.util.List;

public class PairSearching {
    private InputView inputView;
    private OutputView outputView;
    private static final String WRONG_INPUT_MESSAGE = "[ERROR] 잘못된 입력입니다.";
    private static final String NOT_FOUND_MESSAGE = "[ERROR] 매칭 이력이 없습니다.";

    public PairSearching() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        try {
            outputView.printSelectionNotice();
            String[] missionInfo = inputMission().split(",");

            Course targetCourse = Arrays.stream(Course.values())
                    .filter(course -> course.getName().equals(missionInfo[0].trim()))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException(WRONG_INPUT_MESSAGE));

            Level targetLevel = Arrays.stream(Level.values())
                    .filter(level -> level.getName().equals(missionInfo[1].trim()))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException(WRONG_INPUT_MESSAGE));

            String missionName = missionInfo[2].trim();

            getMission(targetCourse, targetLevel, missionName);

        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
        }

    }

    private String inputMission() {
        return inputView.inputMission();
    }

    private void getMission(Course course, Level level, String missionName) {
        try {
            Mission mission = MatchingController.missions.stream()
                    .filter(x -> x.isSameMission(course, level, missionName))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException(WRONG_INPUT_MESSAGE));

            searchMatching(MatchingController.matchingData, mission);


        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
        }
    }

    public void searchMatching(MatchingData matchingData, Mission mission) {
        try {
            if (matchingData.contains(mission)) {
                List<Pair> matching = matchingData.get(mission);
                outputView.printMatchingResult(matching);
                return;
            }
            throw new IllegalArgumentException(NOT_FOUND_MESSAGE);

        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
        }
    }
}
