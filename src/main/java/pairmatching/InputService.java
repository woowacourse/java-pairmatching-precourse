package pairmatching;

import camp.nextstep.edu.missionutils.Console;

public class InputService {
    private final MessageService messageService = new MessageService();
    private final Function function = new Function();

    public int inputFunction() {
        messageService.printWithMessage(function.toString());
        while (true) {
            String input = Console.readLine();
            if (function.isValidOption(input)) {
                return function.getSelectedOption();
            }
        }
    }
}
