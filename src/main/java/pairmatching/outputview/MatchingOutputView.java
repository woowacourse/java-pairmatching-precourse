package pairmatching.outputview;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.vo.RematchingCommand;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MatchingOutputView {

    public static final String LINE_SEPARATOR = "#############################################";
    public static final String MISSION_MESSAGE_FORMAT = "  - %s: ";
    public static final String VALUE_SEPARATOR_LINE = " | ";
    public static final String COURSE_PREFIX = "과정: ";
    public static final String MISSION_PREFIX = "미션:";
    public static final String ASKING_REMATCHING_COMMAND = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?";
    public static final String PAIR_MATCHING_RESULT_MESSAGE = "페어 매칭 결과입니다.";
    public static final String VALUE_SEPARATOR_COLON = " : ";

    public static void printInformation(Map<Level, List<String>> allCrewNamesByLevel) {
        System.out.println();
        System.out.println(LINE_SEPARATOR);

        printCourse();
        printMissions(allCrewNamesByLevel);
        System.out.println(LINE_SEPARATOR);

        printAskingInfoMessage();
    }

    public static void printAskingReMatchingCommand() {
        System.out.println();
        System.out.println(ASKING_REMATCHING_COMMAND);
        printRematchingCommands();
        System.out.println();
    }

    private static void printRematchingCommands() {
        Iterator<RematchingCommand> iterator = Arrays.stream(RematchingCommand.values()).iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next().getCommand());
            addSeparator(iterator, VALUE_SEPARATOR_LINE);
        }
    }

    private static void printAskingInfoMessage() {
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");
    }

    private static void printMissions(Map<Level, List<String>> allCrewNamesByLevel) {
        System.out.println(MISSION_PREFIX);
        for (Level level : Level.values()) {
            System.out.printf(MISSION_MESSAGE_FORMAT, level.getName());
            Iterator<String> iterator = allCrewNamesByLevel.get(level).iterator();
            printMissionNames(iterator);
            System.out.println();
        }
    }

    private static void printCourse() {
        System.out.print(COURSE_PREFIX);
        Iterator<Course> iterator = Arrays.stream(Course.values()).iterator();
        printCourseNames(iterator);
        System.out.println();
    }

    private static void printCourseNames(Iterator<Course> iterator) {
        while (iterator.hasNext()) {
            System.out.print(iterator.next().getName());
            addSeparator(iterator, VALUE_SEPARATOR_LINE);
        }
    }

    private static void printMissionNames(Iterator<String> iterator) {
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            addSeparator(iterator, VALUE_SEPARATOR_LINE);
        }
    }

    private static void addSeparator(Iterator<?> iterator, String separator) {
        if (iterator.hasNext()) {
            System.out.print(separator);
        }
    }

    public static void printPairInformation(List<List<String>> pairs) {
        System.out.println(PAIR_MATCHING_RESULT_MESSAGE);
        for (List<String> pair : pairs) {
            printPair(pair);
        }
    }

    private static void printPair(List<String> pair) {
        Iterator<String> iterator = pair.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            addSeparator(iterator, VALUE_SEPARATOR_COLON);
        }
        System.out.println();
    }

    public static void printResetResult() {
        System.out.println();
        System.out.println("초기화 되었습니다.");
    }
}
