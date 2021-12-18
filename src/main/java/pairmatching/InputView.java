package pairmatching;

import camp.nextstep.edu.missionutils.Console;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static String BACKEND_CREW_LIST = "C:\\Users\\yerim\\java-pairmatching-precourse\\src\\main\\resources\\backend-crew.md";
    public static String FRONTEND_CREW_LIST = "C:\\Users\\yerim\\java-pairmatching-precourse\\src\\main\\resources\\frontend-crew.md";

    public static String inputAction() {
        String inputAction = Console.readLine();
        return inputAction;
    }

    public static String inputCourseLevelMission() {
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");
        String input = Console.readLine();
        String course = input.split(",")[0];
        String level = input.split(",")[1];
        String mission = input.split(",")[2];
        return input;
    }

    public static List<String> inputCrew(String listName) {
        List<String> crewList = new ArrayList<String>();
        if (listName.equals("backend")) {
            Utils.makeFileToList(BACKEND_CREW_LIST);
        }
        if (listName.equals("frontend")) {
            Utils.makeFileToList(FRONTEND_CREW_LIST);
        }
        return crewList;
    }
}
