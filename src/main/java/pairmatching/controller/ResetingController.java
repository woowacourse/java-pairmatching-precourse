package pairmatching.controller;

import pairmatching.outputview.MatchingOutputView;
import pairmatching.service.MatchingService;
import pairmatching.vo.MatchingCommand;

import java.util.Map;

public class ResetingController extends AbstractController {
    @Override
    public void doProcess(Map<String, Object> model) {
        MatchingCommand matchingCommand = getMatchingCommand();
        MatchingService.resetPairMatching(matchingCommand.getCourse(), matchingCommand.getMission());

        MatchingOutputView.printResetResult();
    }
}
