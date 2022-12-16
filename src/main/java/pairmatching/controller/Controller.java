package pairmatching.controller;

import pairmatching.domain.Command;
import pairmatching.domain.choice.Choice;
import pairmatching.domain.choice.ChoiceMaker;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void runMain() {
        executeCommand();
    }

    private void executeCommand() {
        Command command = readValidValueBy(this::readCommand);
        while (!command.isCommandOf(Command.QUITTING)) {
            if (command.isCommandOf(Command.MATCHING)) {
                Choice choice = readValidValueBy(this::readChoice);

            }
            if (command.isCommandOf(Command.CHECKING)) {

            }
            if (command.isCommandOf(Command.INITIALIZING)) {

            }
        }
    }

    private Command readCommand() {
        outputView.printCommandGuide();
        String inputCommand = inputView.readCommand();
        return Command.valueOfCommand(inputCommand);
    }

    private Choice readChoice() {
        outputView.printChoiceGuide();
        List<String> choices = inputView.readChoices();
        ChoiceMaker choiceMaker = new ChoiceMaker();
        return choiceMaker.createChoice(choices);
    }

    private <T> T readValidValueBy(Supplier<T> inputReader) {
        while (true) {
            try {
                return inputReader.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
