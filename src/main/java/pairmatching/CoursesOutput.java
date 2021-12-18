package pairmatching;

import java.util.ArrayList;

public class CoursesOutput {
    private static final String CIRCUMFIX = "#############################################";
    private static final String COURSE_INTRO = "과정: 백엔드 | 프론트엔드";
    private static final String MISSION_INTRO = "미션 :";
    private static final String GUIDE = "과정, 레벨, 미션을 선택하세요.";
    private static final String EXAMPLE = "ex) 백엔드, 레벨1, 자동차경주";
    private static final String LEVEL_PREFIX = " - 레벨";
    private static final String LEVEL_SUFFIX = ": ";
    private static final String LEVEL_DELIMITER = " | ";
    private static final int MIN_LEVEL = 1;
    private static final int MAX_LEVEL = 5;

    public static void printCourseInformation() {
        System.out.println(CIRCUMFIX);
        System.out.println(COURSE_INTRO);
        System.out.println(MISSION_INTRO);
        printCourse();
        System.out.println(CIRCUMFIX);
        System.out.println(GUIDE);
        System.out.println(EXAMPLE);
    }

    private static void printCourse() {
        Courses courses = Courses.getInstance();
        for (int level = 1; level <= 5; level++) {
            ArrayList<String> levelCourses = courses.getCourses(level);
            String courseString = String.join(LEVEL_DELIMITER, levelCourses);
            System.out.println(LEVEL_PREFIX + level + LEVEL_SUFFIX + courseString);
        }
    }
}
