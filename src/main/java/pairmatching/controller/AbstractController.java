package pairmatching.controller;

import pairmatching.domain.Level;
import pairmatching.inputview.MatchingInputView;
import pairmatching.outputview.ExceptionHandlingOutputView;
import pairmatching.outputview.MatchingOutputView;
import pairmatching.repository.MissionRepository;
import pairmatching.vo.MatchingCommand;

import java.util.List;
import java.util.Map;

public abstract class AbstractController implements Controller {
    @Override
    public void process(Map<String, Object> model) {
        try {
            doProcess(model);
        } catch (IllegalArgumentException e) {
            ExceptionHandlingOutputView.printExceptionMessage(e.getMessage());
            process(model);
        }
    }

    protected static MatchingCommand getMatchingCommand() {
        Map<Level, List<String>> allCrewNamesByLevel = MissionRepository.findAllNamesByAllLevel();
        MatchingOutputView.printInformation(allCrewNamesByLevel);
        return MatchingInputView.getCommand();
    }

    public abstract void doProcess(Map<String, Object> model);
}
