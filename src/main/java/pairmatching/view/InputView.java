package pairmatching.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.model.ProgramFunction;

public abstract class InputView {

    private static final String INPUT_MESSAGE_CHOOSE_FUNCTION = "기능을 선택하세요.";
    private static final String NEW_LINE = "\n";
    private static final String ERROR_MESSAGE_NOT_CONTAINS_IN_FUNCTION_LIST = "[ERROR] 기능목록에 있는 기능을 선택해 주세요.";
    private static final String COMMA = ",";
    private static final String BOUNDARY = "#############################################";
    private static final String COLON = ":";
    private static final String MISSION = "미션";
    private static final String DASH = "-";
    private static final String SPACE = " ";
    private static final String VERTICAL_LINE = "|";

    public static List<String> readFrontendCrew() {
        try {
            final List<String> crewNames = new ArrayList<>();
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./src/main/resources/frontend-crew.md"));

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
//            System.out.println(createCourseInformationPrintFormat());
            String inputCourseInformation = inputValue();

            return inputCourseInformation.split(COMMA);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());

            return inputCourseInformation();
        }
    }
//
//    private static boolean createCourseInformationPrintFormat() {
//        final StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(BOUNDARY).append(NEW_LINE).append(MISSION).append(COLON).append(NEW_LINE)
//                .append(DASH).append(SPACE).append(Levels.LEVEL1.getName()).append(Missions.CAR_RACING).append(SPACE).append(VERTICAL_LINE).append(Missions.LOTTO).append(Missions.NUMBER_BASEBALL_GAME)
//
//                .append(BOUNDARY).append(NEW_LINE);
//
//
//        return stringBuilder.toString();
//    }


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
