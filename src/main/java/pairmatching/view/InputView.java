package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import pairmatching.domain.OptionCommand;
import pairmatching.domain.RematchingCommand;

public class InputView {

    private static final String DELIMITER = ", ";

    public String readOption() {
        String input = input().trim();
        return OptionCommand.from(input).getCommand();
    }

    public List<String> readConditions() {
        return Arrays.asList(input().split(DELIMITER));
    }

    public String readRematching() {
        String input = input().trim();
        return RematchingCommand.from(input).getCommand();
    }

    private String input() {
        return Console.readLine();
    }
}
