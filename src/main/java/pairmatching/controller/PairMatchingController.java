package pairmatching.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Crew;
import pairmatching.domain.PairInformation;
import pairmatching.domain.PairMatchingMachine;
import pairmatching.domain.PairMission;
import pairmatching.domain.RandomPairMatchingGenerator;
import pairmatching.domain.command.MainCommand;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

    public void run() {
        MainCommand mainCommand = getMainCommand();
        if (mainCommand == MainCommand.EXIT) {
            return;
        }

        PairMatchingMachine pairMatchingMachine = new PairMatchingMachine(new RandomPairMatchingGenerator());
        pairMatching(pairMatchingMachine);
    }

    private void pairMatching(PairMatchingMachine pairMatchingMachine) {
        PairMission pairMission = getPairMission();
        List<Crew> crews = getCrews(pairMission);
        PairInformation pairInformation = pairMatchingMachine.share(pairMission, crews);
        OutputView.printPairMatchingResult(pairInformation);
    }

    private MainCommand getMainCommand() {
        try {
            return InputView.mainCommand();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getMainCommand();
        }
    }

    private PairMission getPairMission() {
        try {
            return InputView.pairMission();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getPairMission();
        }
    }

    private List<Crew> getCrews(PairMission pairMission) {
        try {
            return InputView.crews(pairMission.getCourse());
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}