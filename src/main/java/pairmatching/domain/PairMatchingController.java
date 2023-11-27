package pairmatching.domain;

import java.util.List;
import pairmatching.domain.pair.PairOption;
import pairmatching.domain.pair.Pairs;
import pairmatching.message.ExceptionMessage;
import pairmatching.message.ProgramOption;
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
            if (validateMenu.equals(ProgramOption.QUIT)) {
                break;
            }
            handleByMenu(validateMenu);
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

    private static void handleByMenu(String validateMenu) {
        if (validateMenu.equals(ProgramOption.PAIR_MATCHING)) {
            handlePairMatching();
            return;
        }
        if (validateMenu.equals(ProgramOption.PAIR_SEARCH)) {
            handlePairSearch();
            return;
        }
        if (validateMenu.equals(ProgramOption.PAIR_RESET)) {
            handlePairReset();
            return;
        }
        throw new IllegalArgumentException(ExceptionMessage.INVALID_MENU_INPUT);
    }

    private static void handlePairMatching() {
        try {
            PairOption pairOption = InputView.readOption();
            pairMatching(pairOption);
        } catch (IllegalArgumentException error) {
            OutputView.printException(error);
            handlePairMatching();
        }
    }

    private static void pairMatching(PairOption pairOption) {
        Pairs matchingResult;
        if (PairMatchingService.hasHistory(pairOption)) {
            handleRematch(pairOption);
            return;
        }
        matchingResult = PairMatchingService.createPairMatching(pairOption);
        OutputView.printMatchingResult(matchingResult);
    }

    private static void handleRematch(PairOption pairOption) {
        if (getValidateRematch().equals(ProgramOption.YES)) {
            // 3번 리매칭
            Pairs matchingResult = tryRematch(pairOption);
            OutputView.printMatchingResult(matchingResult);
            return;
        }
        // 아니오를 선택한 경우 다시 코스, 레벨, 미션을 선택한다.
        handlePairMatching();
    }

    private static Pairs tryRematch(PairOption pairOption) {
        List<Pairs> history = PairMatchingService.getHistory(pairOption.getCourse(), pairOption.getLevel());
        for (int i = 0; i < 3; i++) {
            Pairs rematch = PairMatchingService.createPairMatching(pairOption);
            if (PairMatchingService.hasSamePair(history, rematch)) {
                continue;
            }
            PairMatchingService.addPairsToHistory(pairOption, rematch);
            return rematch;
        }
        throw new IllegalArgumentException(ExceptionMessage.REMATCHING_FAIL);
    }

    private static String getValidateRematch() {
        try {
            return PairMatchingService.getValidateRematch(InputView.readRematch());
        } catch (IllegalArgumentException error) {
            OutputView.printException(error);
            return getValidateRematch();
        }
    }

    private static void handlePairSearch() {
        try {
            PairOption pairOption = InputView.readOption();
            if (!PairMatchingService.hasHistory(pairOption)) {
                throw new IllegalArgumentException(ExceptionMessage.NO_MATCHING_HISTORY);
            }
            Pairs matchedPairs = PairMatchingService.findHistory(pairOption);
            OutputView.printMatchingResult(matchedPairs);
        } catch (IllegalArgumentException error) {
            OutputView.printException(error);
            handlePairSearch();
        }
    }

    private static void handlePairReset() {
        PairMatchingService.reset();
    }
}
