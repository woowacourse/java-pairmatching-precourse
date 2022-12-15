package pairmatching.controller;

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
        UserCommand command = readUserCommand();
        if (command.isCommandOf(Command.MATCHING)) {
            Choice choice = readChoice();

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
        while(true) {
            try {
                outputView.printChoiceGuideMessage(Course.namesOfValues(), Level.namesOfValues(), Mission.values());
                List<String> items = inputView.readChoice();
                return choiceMaker.createChoice(items);
            } catch (IllegalArgumentException e) {
                outputView.print(e.getMessage());
            }
        }
    }

    private UserCommand readUserCommand() {
        while (true) {
            try {
                outputView.printCommandGuideMessage(Command.values());
                String command = inputView.readCommand();
                return new UserCommand(command);
            } catch (IllegalArgumentException e) {
                outputView.print(e.getMessage());
            }
        }
    }
}
