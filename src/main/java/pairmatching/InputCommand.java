package pairmatching;
import camp.nextstep.edu.missionutils.Console;

public class InputCommand {
    private static final String COMMAND_REGEX = "[123Q]";

    public static String getCommand() {
        String data = Console.readLine();
        if (data.matches(COMMAND_REGEX)) {
            return data;
        }
        throw new IllegalArgumentException();
    }


}
