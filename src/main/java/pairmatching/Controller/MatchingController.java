package pairmatching.Controller;

import pairmatching.Menu;
import pairmatching.Model.*;
import pairmatching.View.InputView;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MatchingController {
    public static List<Crew> backEndCrews;
    public static List<Crew> frontEndCrews;
    public static List<Mission> missions;
    public static MatchingData matchingData;
    private InputView inputView;
    private static Menu menu;

    public MatchingController() {
        missions = new ArrayList<>();
        inputView = new InputView();
        menu = new Menu(inputView);
        backEndCrews = new ArrayList<>();
        frontEndCrews = new ArrayList<>();
        matchingData = new MatchingData();
    }

    public static void run() {
        try {
            readCrewData();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        missionInit();
        boolean flag = true;
        while (flag) {
            flag = menu.runMenu();
        }
    }

    private static void missionInit() {

        for (Course course : Course.values()) {
            missions.add(new Mission(course, Level.valueOf("LEVEL1"), "자동차경주"));
            missions.add(new Mission(course, Level.valueOf("LEVEL1"), "로또"));
            missions.add(new Mission(course, Level.valueOf("LEVEL1"), "숫자야구게임"));
            missions.add(new Mission(course, Level.valueOf("LEVEL2"), "장바구니"));
            missions.add(new Mission(course, Level.valueOf("LEVEL2"), "결제"));
            missions.add(new Mission(course, Level.valueOf("LEVEL2"), "지하철노선도"));
            missions.add(new Mission(course, Level.valueOf("LEVEL4"), "성능개선"));
            missions.add(new Mission(course, Level.valueOf("LEVEL4"), "배포"));
        }
    }

    private static void readCrewData() throws IOException {
        Path pathBackEndCrew = Paths.get("src\\main\\resources\\backend-crew.md");
        Path pathFrontEndCrew = Paths.get("src\\main\\resources\\frontend-crew.md");
        Charset cs = StandardCharsets.UTF_8;
        List<String> backEndCrewNames = Files.readAllLines(pathBackEndCrew, cs);
        List<String> frontEndCrewNames = Files.readAllLines(pathFrontEndCrew, cs);
        backEndCrewNames.stream()
                .forEach(name -> backEndCrews.add(new Crew(Course.valueOf("BACKEND"), name)));
        frontEndCrewNames.stream()
                .forEach(name -> frontEndCrews.add(new Crew(Course.valueOf("FRONTEND"), name)));
    }
}
