package pairmatching;
import camp.nextstep.edu.missionutils.Console;

public class InputCommand {
    private static final String COMMAND_REGEX = "[123Q]";
    private static final String SPLIT_REGEX = ",";
    private static final String LEVEL_REGEX = "레벨[1-5]";
    private static final String COURSE_FRONTEND = "프론트엔드";
    private static final String COURSE_BACKEND = "백엔드";
    private static final int LENGTH = 3;

    private static final String ERROR_LENGTH = "[ERROR] 3개의 입력값이 아니다.";
    private static final String ERROR_COURSE = "[ERROR] 백엔드나 프론트엔드만 입력 가능하다.";
    private static final String ERROR_LEVEL = "[ERROR] 레벨(숫자) 형식으로 입력하여야 한다.";

    public static String getCommand() {
        String data = Console.readLine();
        if (data.matches(COMMAND_REGEX)) {
            return data;
        }
        throw new IllegalArgumentException();
    }

    public static String getMatchingCommand() {
        String data = Console.readLine();
        String[] split_data = data.split(SPLIT_REGEX);
        if (split_data.length != LENGTH) {
            throw new IllegalArgumentException(ERROR_LENGTH);
        }
        if (!(split_data[0].trim().equals(COURSE_FRONTEND) || split_data[0].trim().equals(COURSE_BACKEND))) {
            throw new IllegalArgumentException(ERROR_COURSE);
        }
        if (!split_data[1].trim().matches(LEVEL_REGEX)) {
            throw new IllegalArgumentException(ERROR_LEVEL);
        }
        return data;
    }

    private static void validate_course(String level, String course) {
        int levelIntValue = Integer.parseInt(level.substring(2));

        if (Courses.getInstance().getCourses(levelIntValue).contains(course)) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 없는 미션입니다.");
    }

}
