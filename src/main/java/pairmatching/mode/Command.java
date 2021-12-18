package pairmatching.mode;

import java.util.Arrays;
import pairmatching.exception.ErrorMessage;

public enum Command {
    MODE_1("1", new PairMatchingMatching()),
    MODE_2("2", new PairMatchingReference()),
    MODE_3("3", new PairMatchingInitializer());

    private final String input;
    private final PairMatchingService pairMatchingService;

    Command(String input, PairMatchingService service) {
        this.input = input;
        this.pairMatchingService = service;
    }

    public static PairMatchingService findServiceByCommand(String inputCommand) {
        return Command.findByService(Arrays.stream(Command.values())
            .filter(command -> command.input.equals(inputCommand))
            .findAny()
            .orElseThrow(ErrorMessage.INVALID_COMMAND::getException));
    }

    private static PairMatchingService findByService(Command command) {
        return command.pairMatchingService;
    }

}
