package pairmatching.view;

import static pairmatching.constants.ProgressMessage.COURSE_CHOICE;
import static pairmatching.constants.ProgressMessage.START_CHOICE;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.view.common.Printer;

public class InputView {
    public static String chooseFunction() {
        Printer.printer(START_CHOICE.getMessage());
        return Console.readLine();
    }

    public static String chooseCourse() {
        Printer.printer(COURSE_CHOICE.getMessage());
        return Console.readLine();
    }
}
