package pairmatching.controller;

import pairmatching.domain.choice.Course;
import pairmatching.domain.choice.Level;
import pairmatching.domain.choice.Mission;
import pairmatching.domain.program.PairMatchingProgram;
import pairmatching.domain.program.command.Command;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

    private final InputView inputView;
    private final OutputView outputView;

    public PairMatchingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void runPairMatchingProgram() {
        executeUserCommand();
        outputView.printChoiceGuideMessage(Course.namesOfValues(), Level.namesOfValues(), Mission.values());
        inputView.readChoice();
    }

    private void executeUserCommand() {
        PairMatchingProgram program = new PairMatchingProgram();
        outputView.printCommandGuideMessage(Command.values());
        program.executeCommand(inputView.readCommand());
    }
}
