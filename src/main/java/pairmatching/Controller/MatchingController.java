package pairmatching.Controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MatchingController {
    public MatchingController() {

    }

    public static void run() {
        try {
            readCrewData();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void readCrewData() throws IOException {
        Path pathBackEndCrew = Paths.get("C:\\Users\\rjsdnd0316\\Desktop\\java-pairmatching-precourse\\src\\main\\resources\\backend-crew.md");
        Path pathFrontEndCrew = Paths.get("C:\\Users\\rjsdnd0316\\Desktop\\java-pairmatching-precourse\\src\\main\\resources\\frontend-crew.md");
        Charset cs = StandardCharsets.UTF_8;
        List<String> backEndCrewNames = Files.readAllLines(pathBackEndCrew, cs);
        List<String> frontEndCrewNames = Files.readAllLines(pathFrontEndCrew, cs);

    }
}
