package pairmatching.view;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

import static pairmatching.util.Constants.*;

public class InputView {

    public static List<String> readFile(String filePath) {
        List<String> lines = new ArrayList<>();
        try {
            Path path = Paths.get(filePath);
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            OutputView.printErrorMsg(e);
        }
        return lines;
    }

    public static String selectFunctionMenu() {
        System.out.println(FUNCTION_MAIN);
        System.out.println(FUNCTION_1);
        System.out.println(FUNCTION_2);
        System.out.println(FUNCTION_3);
        return Console.readLine();
    }

    public static String selectCLMMenu() {
        System.out.println();
        System.out.println(MENU_DELIMETER);
        System.out.println(MENU_COURSES);
        System.out.println(MENU_MISSION);
        System.out.println(LEVEL_1);
        System.out.println(LEVEL_2);
        System.out.println(LEVEL_3);
        System.out.println(LEVEL_4);
        System.out.println(LEVEL_5);
        System.out.println(MENU_DELIMETER);
        System.out.println(SELECT_C_L_M);
        System.out.println(EX_C_L_M);
        return Console.readLine();
    }

    public static String fairMatchingMenu() {

    }

    public static String reMatching() {
        System.out.println(ASK_REMATCHING_MSG);
        System.out.println(REMATCHING_OPTION_MSG);
        return Console.readLine();
    }

    public static String fairLookUp() {
        return "";
    }

    public static String fairInit() {
        return "";
    }
}
