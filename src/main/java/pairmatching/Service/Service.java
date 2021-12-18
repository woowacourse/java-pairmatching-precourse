package pairmatching.Service;

import pairmatching.Model.Course;
import pairmatching.Model.Level;
import pairmatching.util.Symbol;
import pairmatching.util.ViewMessage;

public abstract class Service {
	public static String printCourseAndLevelInfo() {
		StringBuilder builder = new StringBuilder();
		return builder.append(ViewMessage.START_END_PRINT_INFO.getMessage() + Symbol.NEW_LINE)
			.append(Course.getCourseInfo() + Symbol.NEW_LINE)
			.append(
				Level.getLevelInfo())
			.append(ViewMessage.START_END_PRINT_INFO.getMessage()).toString();
	}

}
