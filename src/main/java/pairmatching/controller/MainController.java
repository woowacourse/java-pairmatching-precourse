package pairmatching.controller;

import pairmatching.controller.command.MainCommand;
import pairmatching.controller.command.ReMatchingCommand;
import pairmatching.domain.choice.Choice;
import pairmatching.domain.crew.Crew;
import pairmatching.domain.matching.MatchingHistory;
import pairmatching.domain.matching.MatchingProgram;
import pairmatching.domain.matching.PairMatchingMachine;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;
    private final InputController inputController;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputController = new InputController(inputView, outputView);
    }

    public void runMain() {
        try {
            runProgram();
        } catch (IOException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }

    private void runProgram() throws IOException {
        executeCommand();
    }

    private void executeCommand() throws IOException {
        MainCommand command;
        MatchingProgram program = new MatchingProgram(new MatchingHistory(), new PairMatchingMachine());
        do {
            command = inputController.readValidCommand();
            decideAndExecute(command, program);
        } while (!command.isCommandOf(MainCommand.QUITTING));
    }

    private void decideAndExecute(MainCommand command, MatchingProgram program) throws IOException {
        if (command.isCommandOf(MainCommand.MATCHING)) {
            executeMatchingCommand(program);
        }
        if (command.isCommandOf(MainCommand.CHECKING)) {
            executeCheckingCommand(program);
        }
        if (command.isCommandOf(MainCommand.INITIALIZING)) {
            executeInitializingCommand(program);
        }
    }

    private void executeMatchingCommand(MatchingProgram program) throws IOException {
        List<Set<Crew>> pairs = new ArrayList<>();
        while (pairs.isEmpty()) {
            Choice choice = inputController.readValidChoice();
            if (program.hasMatched(choice)) {
                executeReMatchingCommand(program, choice);
            }
            if (!program.hasMatched(choice)) {
                pairs = program.matchAndRecord(choice);
            }
        }
        outputView.printMatchingResult(pairs);
    }

    private void executeReMatchingCommand(MatchingProgram program, Choice choice) throws IOException {
        ReMatchingCommand command = inputController.readValidReMatchingCommand();
        if (command.isCommandOf(ReMatchingCommand.RE_MATCHING)) {
            program.deleteHistory(choice);
        }
    }

    private void executeCheckingCommand(MatchingProgram program) {
        Choice choice = inputController.readValidChoice();
        List<Set<Crew>> pairs = program.show(choice);
        outputView.printMatchingResult(pairs);
    }

    private void executeInitializingCommand(MatchingProgram program) {
        program.truncateHistory();
        outputView.printInitializingMessage();
    }
}
