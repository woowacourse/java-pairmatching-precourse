package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import pairmatching.domain.Command;
import pairmatching.domain.Level;

public class InputView {

    private static final String SELECT_COMMAND = "기능을 선택하세요.";
    private static final String COMMAND_LIST = "%s. %s\n";

    private static final String COURSE = "과정: ";
    private static final String MISSION = "미션:";
    private static final String MISSION_LEVEL = "  - %s: %s";

    private static final String INPUT_COURSE_LEVEL_MISSION = "과정, 레벨, 미션을 선택하세요.\nex) 백엔드, 레벨1, 자동차경주";

    private static final String INPUT_ALREADY_MATCH = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n네 | 아니오";

    private static final String PRINT_DELEMITER = "############################################";
    private static final String LIST_DELEMITER = " | ";
    private static final String DELEMITER = ",";

    private InputView() {
    }

    public static List<String> inputBackEndCrews() {
        try {
            File file = new File("src/main/resources/backend-crew.md");
            Scanner scanner = new Scanner(file);
            List<String> crews = new ArrayList<>();
            while(scanner.hasNextLine()) {
                crews.add(scanner.nextLine());
            }
            return crews;
        } catch (FileNotFoundException e) {
            System.out.println("파일 입력이 에러가 발생했습니다.");
            throw new RuntimeException(e.getMessage());
        }
    }

    public static List<String> inputFrondEndCrews() {
        try {
            File file = new File("src/main/resources/backend-crew.md");
            Scanner scanner = new Scanner(file);
            List<String> crews = new ArrayList<>();
            while(scanner.hasNextLine()) {
                crews.add(scanner.nextLine());
            }
            return crews;
        } catch (FileNotFoundException e) {
            System.out.println("파일 입력이 에러가 발생했습니다.");
            throw new RuntimeException(e.getMessage());
        }
    }

    public static List<String> inputFirstLevelMission() {
        try {
            File file = new File("src/main/resources/level-one.md");
            Scanner scanner = new Scanner(file);
            List<String> missionNames = new ArrayList<>();
            while(scanner.hasNextLine()) {
                missionNames.add(scanner.nextLine());
            }
            return missionNames;
        } catch (FileNotFoundException e) {
            System.out.println("파일 입력이 에러가 발생했습니다.");
            throw new RuntimeException(e.getMessage());
        }
    }

    public static List<String> inputSecondLevelMission() {
        try {
            File file = new File("src/main/resources/level-two.md");
            Scanner scanner = new Scanner(file);
            List<String> missionNames = new ArrayList<>();
            while(scanner.hasNextLine()) {
                missionNames.add(scanner.nextLine());
            }
            return missionNames;
        } catch (FileNotFoundException e) {
            System.out.println("파일 입력이 에러가 발생했습니다.");
            throw new RuntimeException(e.getMessage());
        }
    }

    public static List<String> inputThirdLevelMission() {
        try {
            File file = new File("src/main/resources/level-three.md");
            Scanner scanner = new Scanner(file);
            List<String> missionNames = new ArrayList<>();
            while(scanner.hasNextLine()) {
                missionNames.add(scanner.nextLine());
            }
            return missionNames;
        } catch (FileNotFoundException e) {
            System.out.println("파일 입력이 에러가 발생했습니다.");
            throw new RuntimeException(e.getMessage());
        }
    }

    public static List<String> inputFourthLevelMission() {
        try {
            File file = new File("src/main/resources/level-four.md");
            Scanner scanner = new Scanner(file);
            List<String> missionNames = new ArrayList<>();
            while(scanner.hasNextLine()) {
                missionNames.add(scanner.nextLine());
            }
            return missionNames;
        } catch (FileNotFoundException e) {
            System.out.println("파일 입력이 에러가 발생했습니다.");
            throw new RuntimeException(e.getMessage());
        }
    }

    public static List<String> inputFifthLevelMission() {
        try {
            File file = new File("src/main/resources/level-five.md");
            Scanner scanner = new Scanner(file);
            List<String> missionNames = new ArrayList<>();
            while(scanner.hasNextLine()) {
                missionNames.add(scanner.nextLine());
            }
            return missionNames;
        } catch (FileNotFoundException e) {
            System.out.println("파일 입력이 에러가 발생했습니다.");
            throw new RuntimeException(e.getMessage());
        }
    }

    public static String inputCommand(List<Command> commands) {
        System.out.println(SELECT_COMMAND);
        commands.forEach(InputView::printCommand);
        return Console.readLine();
    }

    private static void printCommand(Command command) {
        System.out.printf(COMMAND_LIST, command.request(), command.commandName());
    }

    public static void printCurrentBoard(List<String> courses, Map<Level, List<String>> missions) {
        System.out.println(PRINT_DELEMITER);
        System.out.print(COURSE);
        System.out.println(printCourses(courses));
        System.out.println(MISSION);
        for (Level level : missions.keySet()) {
            System.out.printf(MISSION_LEVEL, level.getName(), printMissions(missions.get(level)));
            System.out.println();
        }
        System.out.println(PRINT_DELEMITER);
    }

    private static String printCourses(List<String> courses) {
        return String.join(LIST_DELEMITER, courses);
    }

    private static String printMissions(List<String> missions) {
        return String.join(LIST_DELEMITER, missions);
    }

    public static List<String> inputCourseAndLevelAndMission() {
        System.out.println(INPUT_COURSE_LEVEL_MISSION);
        return Arrays.stream(Console.readLine().split(DELEMITER))
            .map(String::trim)
            .collect(Collectors.toList());
    }

    public static String inputAlreadyMatching() {
        System.out.println(INPUT_ALREADY_MATCH);
        return Console.readLine();
    }
}
