package pairmatching.status;

import java.util.Arrays;
import pairmatching.exception.ErrorMessage;

public enum Command {
    MODE_1("1", new PairMatching()),
    MODE_2("2", new PairMatchingReference()),
    MODE_3("3", new PairMatchingInitializer());

    private final String input;
    private final PairMatchingApplicationStatus pairMatchingApplicationStatus;

    Command(String input, PairMatchingApplicationStatus service) {
        this.input = input;
        this.pairMatchingApplicationStatus = service;
    }

    public static PairMatchingApplicationStatus findServiceByCommand(String inputCommand) {
        return Command.findByService(Arrays.stream(Command.values())
            .filter(command -> command.input.equals(inputCommand))
            .findAny()
            .orElseThrow(ErrorMessage.NOT_FOUND_COMMAND::getException));
    }

    private static PairMatchingApplicationStatus findByService(Command command) {
        return command.pairMatchingApplicationStatus;
    }

}
