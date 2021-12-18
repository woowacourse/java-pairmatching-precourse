package pairmatching.Service;

import pairmatching.Controller.MatchingController;
import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.Model.*;
import pairmatching.View.InputView;
import pairmatching.View.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairMatching {
    private InputView inputView;
    private OutputView outputView;

    public PairMatching() {
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
                    .orElseThrow(() -> new IllegalArgumentException("[ERROR] 잘못된 입력입니다."));
            Level targetLevel = Arrays.stream(Level.values())
                    .filter(level -> level.getName().equals(missionInfo[1].trim()))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("[ERROR] 잘못된 입력입니다."));
            String missionName = missionInfo[2].trim();
            runMission(targetCourse, targetLevel, missionName);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
        }
    }

    private String inputMission() {
        return inputView.inputMission();
    }

    private void runMission(Course course, Level level, String missionName) {
        try {
            Mission mission = MatchingController.missions.stream()
                    .filter(x -> x.isSameMission(course, level, missionName))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("[ERROR] 잘못된 입력입니다."));
            updateMatching(mission, course);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
        }
    }

    private void updateMatching(Mission mission, Course course) {
        if (MatchingController.matchingData.contains(mission)) {
            alreadyExist(mission, course);
            return;
        }
        MatchingController.matchingData.put(mission, tryMatching(course));
    }

    private void alreadyExist(Mission mission, Course course) {
        try {
            outputView.printAskRematching();
            if (inputRematching().equals("네")) {
                MatchingController.matchingData.put(mission, tryMatching(course));
            }
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
        }
    }

    private String inputRematching() {
        return inputView.inputRematching();
    }

    private List<Pair> tryMatching(Course course) {
        List<Crew> crews = Randoms.shuffle(getCrews(course));
        List<Pair> matching = new ArrayList<>();

        int count = 0;
        while (count < crews.size() - 3) {
            matching.add(new Pair(crews.get(count), crews.get(count + 1)));
            count += 2;
        }
        matching.add(getLastPair(count, crews));
        outputView.printMatchingResult(matching);
        return matching;
    }

    private Pair getLastPair(int count, List<Crew> crews) {
        if (count == crews.size() - 3) {
            return (new Pair(crews.get(count), crews.get(count + 1), crews.get(count + 2)));
        }
        return (new Pair(crews.get(count), crews.get(count + 1)));
    }

    private List<Crew> getCrews(Course course) {
        if (Course.valueOf("BACKEND").equals(course)) {
            return MatchingController.backEndCrews;
        }
        return MatchingController.frontEndCrews;
    }
}
