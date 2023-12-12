package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.OptionCommand;

public class InputView {

    public String readCommand() {
        String input = input().trim();
        return OptionCommand.from(input).getCommand();
    }

    public String readInfo() {
        return input();
    }

    private String input() {
        return Console.readLine();
    }
}
