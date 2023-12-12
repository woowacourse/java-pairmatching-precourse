package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.OptionCommand;

public class InputView {

    public String readCommand() {
        String input = input();
        return OptionCommand.from(input).getCommand();
    }

    private String input() {
        return Console.readLine();
    }
}
