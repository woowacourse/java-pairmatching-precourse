package pairmatching.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.model.Course;
import pairmatching.model.Levels;
import pairmatching.model.ProgramFunction;

public abstract class InputView {

    private static final String INPUT_MESSAGE_CHOOSE_FUNCTION = "기능을 선택하세요.";
    private static final String NEW_LINE = "\n";
    private static final String ERROR_MESSAGE_NOT_CONTAINS_IN_FUNCTION_LIST = "[ERROR] 기능목록에 있는 기능을 선택해 주세요.";
    private static final String COMMA = ",";
    private static final String BOUNDARY = "#############################################";
    private static final String COLON = ":";
    private static final String MISSION = "미션";
    private static final String BACKEND_FILE_PATH = "./src/main/resources/backend-crew.md";
    private static final String FRONTEND_FILE_PATH = "./src/main/resources/frontend-crew.md";
    private static final String INPUT_MESSAGE_CHOOSE_COURSE_INFORMATION = "과정, 레벨, 미션을 선택하세요.";
    private static final String LEVEL1_COURSE_INFORMATION = "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임";
    private static final String LEVEL2_COURSE_INFORMATION = "  - 레벨2: 장바구니 | 결제 | 지하철노선도";
    private static final String LEVEL5_COURSE_INFORMATION = "  - 레벨5: ";
    private static final String LEVEL3_COURSE_INFORMATION = "  - 레벨3: ";
    private static final String LEVEL4_COURSE_INFORMATION = "  - 레벨4: 성능개선 | 배포";
    private static final String INPUT_COURSE_INFORMATION_EXAMINATION = "ex) 백엔드, 레벨1, 자동차경주";
    private static final int COURSE_INDEX = 0;
    private static final int LEVEL_INDEX = 1;
    private static final int MISSION_INDEX = 2;
    private static final String ERROR_MESSAGE_NOT_CONTAINS_COURSES = "[ERROR] 해당 과정이 존재하지 않습니다.";
    private static final String ERROR_MESSAGE_NOT_CONTAINS_LEVELS = "[ERROR] 해당 레벨이 존재하지 않습니다.";

    public static List<String> readFrontendCrew() {
        try {
            final List<String> crewNames = new ArrayList<>();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(FRONTEND_FILE_PATH));

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                crewNames.add(line);
            }

            return crewNames;
        } catch (IOException e) {
            e.printStackTrace();

            return readFrontendCrew();
        }
    }

    public static List<String> readBackendCrew() {
        try {
            final List<String> crewNames = new ArrayList<>();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(BACKEND_FILE_PATH));

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                crewNames.add(line);
            }

            return crewNames;
        } catch (IOException e) {
            e.printStackTrace();

            return readFrontendCrew();
        }
    }

    public static String[] inputCourseInformation() {
        try {
            System.out.println(createCourseInformationPrintFormat());
            String inputCourseInformation = inputValue();
            String[] splitInputCourseInformation = inputCourseInformation.split(COMMA);
            validateCourseInformation(splitInputCourseInformation);

            return splitInputCourseInformation;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());

            return inputCourseInformation();
        }
    }

    private static void validateCourseInformation(final String[] splitInputCourseInformation) {
        validateCourse(splitInputCourseInformation[COURSE_INDEX]);
        validateLevel(splitInputCourseInformation[LEVEL_INDEX]);
    }

    private static void validateLevel(final String inputLevel) {
        boolean isContainsInputLevel = true;

        for (Levels level: Levels.values()) {
            if (level.getLevel().equals(inputLevel.trim())) {
                isContainsInputLevel = false;
                break;
            }
        }

        if(isContainsInputLevel){
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_CONTAINS_LEVELS);
        }
    }

    private static void validateCourse(final String inputCourseName) {
        boolean isContainsInputCourseName = true;

        for (Course course:Course.values()) {
            if (course.getName().equals(inputCourseName.trim())) {
                isContainsInputCourseName = false;
                break;
            }
        }

        if(isContainsInputCourseName){
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_CONTAINS_COURSES);
        }
    }

    private static String createCourseInformationPrintFormat() {
        return NEW_LINE + BOUNDARY + NEW_LINE + MISSION + COLON + NEW_LINE
                + LEVEL1_COURSE_INFORMATION + NEW_LINE
                + LEVEL2_COURSE_INFORMATION + NEW_LINE
                + LEVEL3_COURSE_INFORMATION + NEW_LINE
                + LEVEL4_COURSE_INFORMATION + NEW_LINE
                + LEVEL5_COURSE_INFORMATION + NEW_LINE
                + BOUNDARY + NEW_LINE
                + INPUT_MESSAGE_CHOOSE_COURSE_INFORMATION + NEW_LINE
                + INPUT_COURSE_INFORMATION_EXAMINATION;
    }


    public static String inputPairMatchingFunction() {
        try {
            System.out.print(createProvidingFunctionPrintFormat());

            String inputFunctionSignal = inputValue();
            validateInputFunctionSignal(inputFunctionSignal);

            return inputFunctionSignal;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());

            return inputPairMatchingFunction();
        }
    }

    private static String createProvidingFunctionPrintFormat() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(INPUT_MESSAGE_CHOOSE_FUNCTION + NEW_LINE);

        for (ProgramFunction programFunction : ProgramFunction.values()) {
            stringBuilder.append(programFunction.getSignal()).append(NEW_LINE);
        }

        return stringBuilder.toString();
    }

    private static void validateInputFunctionSignal(final String inputFunctionSignal) {
        boolean isInputFunctionSignal = true;

        for (ProgramFunction programFunction : ProgramFunction.values()) {
            if (programFunction.getSignal().contains(inputFunctionSignal)) {
                isInputFunctionSignal = false;
                break;
            }
        }

        if (isInputFunctionSignal) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_CONTAINS_IN_FUNCTION_LIST);
        }
    }

    public static String inputValue() {
        return Console.readLine();
    }

}
