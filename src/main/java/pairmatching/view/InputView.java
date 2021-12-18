package pairmatching.view;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
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

    public static String selectFunction() {
        System.out.println(FUNCTION_MAIN);
        System.out.println(FUNCTION_1);
        System.out.println(FUNCTION_2);
        System.out.println(FUNCTION_3);
        return Console.readLine();
    }

    public static String function1(){
        return "";
    }


}
