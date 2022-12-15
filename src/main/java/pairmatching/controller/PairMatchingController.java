package pairmatching.controller;

import pairmatching.domain.MatchingHistory;
import pairmatching.domain.MatchingMachine;
import pairmatching.domain.choice.Choice;
import pairmatching.domain.choice.ChoiceMaker;
import pairmatching.domain.choice.item.Course;
import pairmatching.domain.choice.item.Level;
import pairmatching.domain.choice.item.Mission;
import pairmatching.domain.command.UserCommand;
import pairmatching.domain.program.PairMatchingProgram;
import pairmatching.domain.command.Command;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class PairMatchingController {

    private final InputView inputView;
    private final OutputView outputView;

    public PairMatchingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void runPairMatchingProgram() {
        executeUserCommand();


    }

    private void executeUserCommand() {
        PairMatchingProgram program = new PairMatchingProgram(new MatchingHistory(), new MatchingMachine());
        UserCommand command = repeat(this::readUserCommand);
        if (command.isCommandOf(Command.MATCHING)) {
            Choice choice = repeat(this::readChoice);
            if (program.hasMatched(choice)) {
                outputView.printReMatchingGuide();
                inputView.readReMatchingCommand();
            }
        }
        if (command.isCommandOf(Command.CHECKING)) {

        }
        if (command.isCommandOf(Command.RESETTING)) {

        }
        if (command.isCommandOf(Command.QUITTING)) {

        }
    }

    private Choice readChoice() {
        ChoiceMaker choiceMaker = new ChoiceMaker();
        outputView.printChoiceGuideMessage(Course.namesOfValues(), Level.namesOfValues(), Mission.values());
        List<String> items = inputView.readChoice();
        return choiceMaker.createChoice(items);
    }

    private UserCommand readUserCommand() {
        outputView.printCommandGuideMessage(Command.values());
        String command = inputView.readCommand();
        return new UserCommand(command);
    }

    private <T> T repeat(Supplier<T> inputReader) {
        while(true) {
            try {
                return inputReader.get();
            } catch (IllegalArgumentException e) {
                outputView.print(e.getMessage());
            }
        }
    }
}
