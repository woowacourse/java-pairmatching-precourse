package pairmatching;


import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    private static final ClassLoader loader = Application.class.getClassLoader();
    private static final String SELECT_FUNCTION_INSTRUCTION = "기능을 선택하세요. ";
    private static final String PAIR_MATCHING_INSTRUCTION = "1. 페어 매칭 ";
    private static final String PAIR_CHECK_INSTRUCTION = "2. 페어 조회 ";
    private static final String PAIR_INITALIZATION = "3. 페어 초기화 ";
    private static final String QUIT_INSTRUCTION = "Q. 종료";
    private static final int MIN_SELECTION_NUMBER = 1;
    private static final int MAX_SELECTION_NUMBER = 3;
    private static final String QUIT_SELECTION_STRING = "Q";
    private static final String ERROR_HEADER = "[ERROR] ";
    private static final String NOT_IN_RANGE_NUMEBR_ERROR = "선택할 수 없는 숫자입니다. 기능 숫자 범위 내의 숫자를 입력해주세요. ";
    private static final String NOT_IN_RANGE_STRING_ERROR = "선택할 수 없는 문자입니다. 기능 범위 내의 숫자를 입력해주세요. ";
    private static final String NOT_EXIST_FILE = "존재하지 않는 파일입니다. ";
    private static final char PATH_CHAR = '/' ;


    public String inputSelectionNumber() {
        try {
            printSelectionInstruction();
            String inputString = Console.readLine();
            return validSelection(inputString);
        } catch (IllegalArgumentException e) {
            printMessage(e.getMessage());
            return inputSelectionNumber();
        }
    }

    public List<Crew> getCrewFromFile(String fileName, Course course) {
        List<Crew> crews = new ArrayList<>();
        File file = getFileByPath(fileName);
        for (String crew : readFile(file)) {
            crews.add(new Crew(course, crew));
        }
        return crews;
    }

    private List<String> readFile(File file) {
        List<String> stringList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                stringList.add(line);
            }
        } catch (IOException e) {
            printMessage(ERROR_HEADER + e.getMessage());
        }
        return stringList;
    }

    private File getFileByPath(String path) {
        if (path.charAt(0) != PATH_CHAR) {
            path = PATH_CHAR + path;
        }
        return new File(getClass().getResource(path).getFile());
    }

    private void printSelectionInstruction() {
        printMessage(SELECT_FUNCTION_INSTRUCTION);
        printMessage(PAIR_MATCHING_INSTRUCTION);
        printMessage(PAIR_CHECK_INSTRUCTION);
        printMessage(PAIR_INITALIZATION);
        printMessage(QUIT_INSTRUCTION);
    }

    private String validSelection(String inputString) {
        if (inputString.matches("[0-9]+")) {
            return validSelectionNumber(inputString);
        }

        if (inputString.equals(QUIT_SELECTION_STRING)) {
            return inputString;
        }
        throw new IllegalArgumentException(ERROR_HEADER + NOT_IN_RANGE_STRING_ERROR);
    }

    private String validSelectionNumber(String inputString) {
        int selectionNumber = Integer.valueOf(inputString);
        if (selectionNumber >= MIN_SELECTION_NUMBER && selectionNumber <= MAX_SELECTION_NUMBER) {
            return inputString;
        }
        throw new IllegalArgumentException(ERROR_HEADER + NOT_IN_RANGE_NUMEBR_ERROR);
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
