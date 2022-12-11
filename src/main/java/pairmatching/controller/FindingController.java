package pairmatching.controller;

import pairmatching.outputview.MatchingOutputView;
import pairmatching.service.MatchingService;
import pairmatching.vo.MatchingCommand;

import java.util.List;
import java.util.Map;

public class FindingController extends AbstractController {
    @Override
    public void doProcess(Map<String, Object> model) {
        MatchingCommand matchingCommand = getMatchingCommand();

        List<List<String>> pairs
                = MatchingService.findAllPairs(matchingCommand.getCourse(), matchingCommand.getMission());
        MatchingOutputView.printPairInformation(pairs);
    }
}
