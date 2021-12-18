package pairmatching.Controller;

import pairmatching.Model.Level;
import pairmatching.Model.Mission;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MatchingController {
    private static List<Mission> missions;
    public MatchingController() {
        missions = new ArrayList<>();
    }

    public static void run() {
        try {
            readCrewData();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        missionInit();

    }

    private static void missionInit() {

        missions.add(new Mission(Level.valueOf("LEVEL1"), "자동차경주"));
        missions.add(new Mission(Level.valueOf("LEVEL1"), "로또"));
        missions.add(new Mission(Level.valueOf("LEVEL1"), "숫자야구게임"));
        missions.add(new Mission(Level.valueOf("LEVEL2"), "장바구니"));
        missions.add(new Mission(Level.valueOf("LEVEL2"), "결제"));
        missions.add(new Mission(Level.valueOf("LEVEL2"), "지하철노선도"));
        missions.add(new Mission(Level.valueOf("LEVEL4"), "성능개선"));
        missions.add(new Mission(Level.valueOf("LEVEL4"), "배포"));

    }

    private static void readCrewData() throws IOException {
        Path pathBackEndCrew = Paths.get("C:\\Users\\rjsdnd0316\\Desktop\\java-pairmatching-precourse\\src\\main\\resources\\backend-crew.md");
        Path pathFrontEndCrew = Paths.get("C:\\Users\\rjsdnd0316\\Desktop\\java-pairmatching-precourse\\src\\main\\resources\\frontend-crew.md");
        Charset cs = StandardCharsets.UTF_8;
        List<String> backEndCrewNames = Files.readAllLines(pathBackEndCrew, cs);
        List<String> frontEndCrewNames = Files.readAllLines(pathFrontEndCrew, cs);

    }
}
