package pairmatching.mode;

import java.util.Arrays;

public enum Command {
    MODE_1("1", new PairMatchingMatching()),
    MODE_2("2", new PairMatchingReference()),
    MODE_3("3", new PairMatchingInitializer());

    private String input;
    private PairMatchingService pairMatchingService;

    Command(String input, PairMatchingService service) {
        this.input = input;
        this.pairMatchingService = service;
    }

    public static PairMatchingService findServiceByCommand(String inputCommand) {
        return Command.findByService(Arrays.stream(Command.values())
            .filter(command -> command.input.equals(inputCommand))
            .findAny()
            .orElseThrow(IllegalArgumentException::new));
    }

    private static PairMatchingService findByService(Command command) {
        return command.pairMatchingService;
    }

}
