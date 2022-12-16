package pairmatching.controller;

import pairmatching.controller.command.MainCommand;
import pairmatching.controller.command.ReMatchingCommand;
import pairmatching.domain.choice.Choice;
import pairmatching.domain.choice.ChoiceMaker;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class InputController {

    private final InputView inputView;
    private final OutputView outputView;

    public InputController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public MainCommand readValidCommand() {
        return repeatUntilGettingValidValue(this::readCommand);
    }

    public Choice readValidChoice() {
        return repeatUntilGettingValidValue(this::readChoice);
    }

    public ReMatchingCommand readValidReMatchingCommand() {
        return repeatUntilGettingValidValue(this::readReMatchingCommand);
    }

    private MainCommand readCommand() {
        outputView.printCommandGuide();
        String inputCommand = inputView.readCommand();
        return MainCommand.valueOfCommand(inputCommand);
    }

    private Choice readChoice() {
        outputView.printChoiceGuide();
        List<String> choices = inputView.readChoices();
        ChoiceMaker choiceMaker = new ChoiceMaker();
        return choiceMaker.createChoice(choices);
    }

    private ReMatchingCommand readReMatchingCommand() {
        outputView.printReMatchingGuide();
        String input = inputView.readReMatchingCommand();
        return ReMatchingCommand.valueOfReMatchingCommand(input);
    }

    private <T> T repeatUntilGettingValidValue(Supplier<T> getSomething) {
        while (true) {
            try {
                return getSomething.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public <T> void repeatUntilGettingValidValue(Consumer<T> getSomething, T input) {
        boolean isContinuing = true;
        while (isContinuing) {
            try {
                getSomething.accept(input);
                isContinuing = false;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
