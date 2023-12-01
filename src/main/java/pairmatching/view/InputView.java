package pairmatching.view;

import static pairmatching.constants.ProgressMessage.COURSE_CHOICE;
import static pairmatching.constants.ProgressMessage.RETRY_COURSE;
import static pairmatching.constants.ProgressMessage.START_CHOICE;
import static pairmatching.view.common.Printer.*;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.view.common.Printer;

public class InputView {
    public static String chooseFunction() {
        printer(START_CHOICE.getMessage());
        return Console.readLine();
    }

    public static String chooseCourse() {
        printer(COURSE_CHOICE.getMessage());
        return Console.readLine();
    }

    public static String inputRetryCourse() {
        printer(RETRY_COURSE.getMessage());
        return Console.readLine();
    }
}
