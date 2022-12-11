package pairmatching.controller;

import pairmatching.inputview.MatchingInputView;
import pairmatching.outputview.ExceptionHandlingOutputView;
import pairmatching.outputview.MatchingOutputView;
import pairmatching.service.MatchingService;
import pairmatching.system.exception.PairMatchingAlreadyExistException;
import pairmatching.system.exception.SamePairMatchedAtSameLevelException;
import pairmatching.vo.MatchingCommand;
import pairmatching.vo.RematchingCommand;

import java.util.List;
import java.util.Map;

public class MatchingController extends AbstractController {

    public static final int DUPLICATING_LIMIT_COUNT = 3;
    public static final String MATCHING_FAILED_MESSAGE = "페어 매칭에 실패했습니다.";

    @Override
    public void doProcess(Map<String, Object> model) {
        MatchingCommand matchingCommand = getMatchingCommand();
        try {
            MatchingService.checkPairMatchingAlreadyExists(matchingCommand.getCourse(), matchingCommand.getMission());
            matchPairs(matchingCommand);
        } catch (PairMatchingAlreadyExistException e) {
            handlePairMatchingAlreadyExistingCondition(matchingCommand);
        }
    }

    private static void matchPairs(MatchingCommand matchingCommand) {
        doMatch(matchingCommand, 0);

        List<List<String>> pairs
                = MatchingService.findAllPairs(matchingCommand.getCourse(), matchingCommand.getMission());
        MatchingOutputView.printPairInformation(pairs);
    }

    private static void doMatch(MatchingCommand matchingCommand, int duplicatedCount) {
        try {
            MatchingService.doMatch(matchingCommand.getCourse(), matchingCommand.getMission());
        } catch (SamePairMatchedAtSameLevelException e) {
            if (duplicatedCount == DUPLICATING_LIMIT_COUNT) {
                ExceptionHandlingOutputView.printExceptionMessage(MATCHING_FAILED_MESSAGE);
                throw e;
            }
            doMatch(matchingCommand, ++duplicatedCount);
        }
    }

    private static void handlePairMatchingAlreadyExistingCondition(MatchingCommand matchingCommand) {
        MatchingOutputView.printAskingReMatchingCommand();
        RematchingCommand rematchingCommand = MatchingInputView.getReMatchingCommand();
        if (rematchingCommand == RematchingCommand.YES) {
            matchPairs(matchingCommand);
        }
    }
}
