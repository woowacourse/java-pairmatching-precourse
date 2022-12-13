package pairmatching.controller;

import pairmatching.domain.Answer;
import pairmatching.domain.Command;
import pairmatching.domain.MatchingInfo;
import pairmatching.domain.pair.Pairs;
import pairmatching.service.MatchingService;
import pairmatching.view.Input;
import pairmatching.view.Output;

public class Matching implements Runnable {

    private final Input input = new Input();
    private final MatchingService matchingService = new MatchingService();

    @Override
    public void run() {
        Command command;
        do {
            command = input.inputCommand();
            if (command == Command.MATCHING) {
                Output.printMissionInfo();
                Output.printPairs(pairMatching());
            } else if (command == Command.SELECT) {
                Output.printMissionInfo();
                Output.printPairs(matchingService.getPairsByMatchInfo(input.inputMatchingInfo()));
            } else if (command == Command.INIT) {
                matchingService.clearRepository();
                Output.printInitMessage();
            }
        } while (command != Command.QUIT);
    }

    private Pairs pairMatching() {
        MatchingInfo matchingInfo = input.inputMatchingInfo();

        return createPairs(matchingInfo);
    }

    private Pairs createPairs(MatchingInfo matchingInfo) {
        if (matchingService.isMatchInfo(matchingInfo)) {
            try {
                if (Answer.NO == Answer.from(input.inputRetryMatch())) {
                    return pairMatching();
                }
            } catch (IllegalArgumentException i) {
                Output.printErrorMessage(i.getMessage());
                return createPairs(matchingInfo);
            }
        }
        return matchingService.saveCrewsByInfo(matchingInfo);
    }

}
