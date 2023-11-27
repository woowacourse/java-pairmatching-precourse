package pairmatching;

import java.util.List;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

    public static void run() {
        PairMatchingService.initCrews();
        proceed();
    }

    private static void proceed() {
        while (true) {
            String validateMenu = getValidateMenu();
            if (validateMenu.equals("Q")) {
                break;
            }
            handleByMenu(validateMenu);
        }
    }

    private static void handleByMenu(String validateMenu) {
        if (validateMenu.equals("1")) {
            handlePairMatching();
            return;
        }
        if (validateMenu.equals("2")) {
            handlePairHistory();
            return;
        }
        if (validateMenu.equals("3")) {
            handlePairReset();
            return;
        }
        throw new IllegalArgumentException("잘못된 입력입니다.");
    }



    private static void handlePairMatching() {
        try {
            String option = InputView.readOption();
            String[] split = option.split(", ");
            if (split.length != 3) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            Course course = Course.findByName(split[0]);
            Level level = Level.findByName(split[1]);
            Mission mission = Mission.findByName(split[2]);

            pairMatching(course, level, mission);
        } catch (IllegalArgumentException error) {
            OutputView.printException(error);
            handlePairMatching();
        }
    }

    private static String getValidateMenu() {
        try {
            return PairMatchingService.getValidateMenu(InputView.readMenu());
        } catch (IllegalArgumentException error) {
            OutputView.printException(error);
            return getValidateMenu();
        }
    }

    private static void pairMatching(Course course, Level level, Mission mission) {
        List<Pair> matchingResult;
        if (PairMatchingService.hasHistory(course, level, mission)) {
            if (getValidateRematch().equals("네")) {
                // 3번 리매칭
                matchingResult = handleRematch(course, level, mission);
                OutputView.printMatchingResult(matchingResult);
                return;
            }
            handlePairMatching(); // 코스, 레벨, 미션을 다시 선택한다.
            return;
        }
        matchingResult = PairMatchingService.pairMatching(course, level, mission);
        OutputView.printMatchingResult(matchingResult);
    }

    private static List<Pair> handleRematch(Course course, Level level, Mission mission) {
        List<List<Pair>> history = PairMatchingService.getHistory(course, level);
        for (int i = 0; i < 3; i++) {
            List<Pair> rematch = PairMatchingService.pairMatching(course, level, mission);
            if (PairMatchingService.hasSamePair(history, rematch)) {
                continue;
            }
            return rematch;
        }
        throw new IllegalArgumentException("3번의 리매칭을 모두 실패했습니다.");
    }

    private static String getValidateRematch() {
        try {
            return PairMatchingService.getValidateRematch(InputView.readRematch());
        } catch (IllegalArgumentException error) {
            OutputView.printException(error);
            return getValidateRematch();
        }
    }

    private static void handlePairHistory() {
        try {
            String option = InputView.readOption();
            String[] split = option.split(", ");
            if (split.length != 3) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            Course course = Course.findByName(split[0]);
            Level level = Level.findByName(split[1]);
            Mission mission = Mission.findByName(split[2]);
            if (!PairMatchingService.hasHistory(course, level, mission)) {
                throw new IllegalArgumentException("매칭 이력이 없습니다.");
            }
            List<Pair> result = PairMatchingService.findHistory(course, level, mission);
            OutputView.printMatchingResult(result);
        } catch (IllegalArgumentException error) {
            OutputView.printException(error);
            handlePairHistory();
        }
    }

    private static void handlePairReset() {
        PairMatchingService.reset();
    }
}
