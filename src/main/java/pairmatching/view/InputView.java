package pairmatching.view;

import static pairmatching.constants.ProgressMessage.CHOOSE_COURSE;
import static pairmatching.constants.ProgressMessage.COURSE_INFO;
import static pairmatching.constants.ProgressMessage.RETRY_COURSE_CHECK;
import static pairmatching.constants.ProgressMessage.START_CHOICE;
import static pairmatching.view.common.Printer.printer;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String chooseFunction() {
        printer(START_CHOICE.getMessage());
        return Console.readLine();
    }

    public static String chooseCourse() {
        printer(COURSE_INFO.getMessage());
        printer(CHOOSE_COURSE.getMessage());
        return Console.readLine();
    }

    public static String chooseRetryCourse(){
        printer(CHOOSE_COURSE.getMessage());
        return Console.readLine();
    }

    public static String inputRetryCheck() {
        printer(RETRY_COURSE_CHECK.getMessage());
        return Console.readLine();
    }
}
