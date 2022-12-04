package pairmatching.outputview;

import pairmatching.model.Level;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SelectingMissionOutputView implements OutputView {

    public static final String SELECT_COURSE_LEVEL_MISSION_MESSAGE = "과정, 레벨, 미션을 선택하세요.";
    public static final String SELECTION_EXAMPLE_MESSAGE = "ex) 백엔드, 레벨1, 자동차경주";
    public static final String PRINTING_MISSION_MESSAGE_FORMAT = "  - %s: ";
    public static final String PRINTING_COURSE_PREFIX = "과정: ";
    public static final String SEPARATOR_FORMAT = " %s ";
    public static final String MISSION_MESSAGE_PREFIX = "미션:";
    public static final String LINE_SEPARATOR = "#############################################";
    public static final String VALUE_SEPARATOR = "|";

    @Override
    public void print(Map<String, Object> model) {
        printLineSeparator();
        printCourses((List<String>) model.get("courses"));
        printMissions(model);
        printLineSeparator();
        printSelectCourseLevelMissionSelectionMessage();
    }

    private static void printSelectCourseLevelMissionSelectionMessage() {
        System.out.println(SELECT_COURSE_LEVEL_MISSION_MESSAGE);
        System.out.println(SELECTION_EXAMPLE_MESSAGE);
    }

    private static void printLineSeparator() {
        System.out.println(LINE_SEPARATOR);
    }

    private void printMissions(Map<String, Object> model) {
        System.out.println(MISSION_MESSAGE_PREFIX);
        printMissionsOfEachLevel(Level.LEVEL1, (List<String>) model.get("level1Missions"));
        printMissionsOfEachLevel(Level.LEVEL2, (List<String>) model.get("level2Missions"));
        printMissionsOfEachLevel(Level.LEVEL3, (List<String>) model.get("level3Missions"));
        printMissionsOfEachLevel(Level.LEVEL4, (List<String>) model.get("level4Missions"));
        printMissionsOfEachLevel(Level.LEVEL5, (List<String>) model.get("level5Missions"));
    }

    private void printMissionsOfEachLevel(Level level, List<String> missions) {
        System.out.printf(PRINTING_MISSION_MESSAGE_FORMAT, level.getName());
        printValues(missions);
    }

    private void printCourses(List<String> courses) {
        System.out.print(PRINTING_COURSE_PREFIX);
        printValues(courses);
    }

    private void printValues(List<String> values) {
        Iterator<String> iterator = values.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            if (iterator.hasNext()) {
                addSeparator(VALUE_SEPARATOR);
            }
        }
        System.out.println();
    }

    private void addSeparator(String separator) {
        System.out.printf(SEPARATOR_FORMAT, separator);
    }
}
