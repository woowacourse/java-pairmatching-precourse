package pairmatching.view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.util.Symbol;
import pairmatching.util.ViewMessage;
import pairmatching.util.validator.CourseInfoValidator;
import pairmatching.util.validator.MenuValidator;

public class InputView {

	public static String enterMainMenu() {
		while (true) {
			try {
				System.out.println(ViewMessage.SELECT_MENU_MSG.getMessage() + Symbol.NEW_LINE);
				String input = Console.readLine();
				MenuValidator.validateMenu(input);
				return input;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void enterCourseAndMissionInfo(){
		while(true){
			try {
				System.out.println(ViewMessage.ENTER_COURSE_INFO_MSG.getMessage() + Symbol.NEW_LINE);
				String input = Console.readLine();
				CourseInfoValidator.validateInfo(input);
				System.out.println(input);
				return;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
