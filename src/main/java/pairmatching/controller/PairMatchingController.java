package pairmatching.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Crew;
import pairmatching.domain.command.MatchCommand;
import pairmatching.domain.PairInformation;
import pairmatching.domain.PairMatchingMachine;
import pairmatching.domain.PairMission;
import pairmatching.domain.RandomPairMatchingGenerator;
import pairmatching.domain.command.MainCommand;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

    public void run() {
        List<PairInformation> pairInformations = new ArrayList<>();
        PairMatchingMachine pairMatchingMachine = new PairMatchingMachine(
            new RandomPairMatchingGenerator(), pairInformations);

        pairMatching(pairMatchingMachine);
    }

    private void pairMatching(PairMatchingMachine pairMatchingMachine) {
        MainCommand mainCommand = getMainCommand();
        if (mainCommand == MainCommand.EXIT) {
            return;
        }

        OutputView.printPairMission();
        PairMission pairMission = getPairMission(pairMatchingMachine);

        if (mainCommand == MainCommand.MATCHING) {
            share(pairMission, pairMatchingMachine);
        }

        if (mainCommand == MainCommand.FIND) {
            find(pairMission, pairMatchingMachine);
        }
    }

    private MainCommand getMainCommand() {
        try {
            return InputView.mainCommand();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getMainCommand();
        }
    }

    private PairMission getPairMission(PairMatchingMachine pairMatchingMachine) {
        PairMission pairMission = InputView.inputPairMission();
        if (pairMatchingMachine.isPairMission(pairMission)) {
            MatchCommand matchCommand = getMatchCommand();
            if (matchCommand == MatchCommand.NO) {
                getPairMission(pairMatchingMachine);
            }
        }
        return pairMission;
    }

    private void share(PairMission pairMission, PairMatchingMachine pairMatchingMachine) {
        List<Crew> crews = getCrews(pairMission);
        PairInformation pairInformation = pairMatchingMachine.share(pairMission, crews);

        pairMatchingMachine.addPairInformation(pairInformation);
        OutputView.printPairMatchingResult(pairInformation);
        pairMatching(pairMatchingMachine);
    }

    private void find(PairMission pairMission, PairMatchingMachine pairMatchingMachine) {
        try {
            PairInformation pairInformation = pairMatchingMachine.findPairInformation(pairMission);
            OutputView.printPairMatchingResult(pairInformation);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            pairMatching(pairMatchingMachine);
        }
    }

    private List<Crew> getCrews(PairMission pairMission) {
        try {
            return InputView.crews(pairMission.getCourse());
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private MatchCommand getMatchCommand() {
        try {
            return InputView.matchingInformation();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getMatchCommand();
        }
    }
}