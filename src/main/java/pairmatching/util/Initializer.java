package pairmatching.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;

public class Initializer {
    public static ArrayList<Crew> registerBackEndCrews() throws IOException{
        ArrayList<Crew> crews = new ArrayList<>();
        List<String> backEndCrewsName = Files.readAllLines(Paths.get(
            "/Users/taehoon/Desktop/wooacourse_test/java-pairmatching-precourse/src/main/resources/backend-crew.md"));
        for (String backEndCrewName : backEndCrewsName) {
            crews.add(new Crew(Course.BACKEND, backEndCrewName));
        }
        return crews;
    }

    public static ArrayList<Crew> registerFrontEndCrews() throws IOException{
        ArrayList<Crew> crews = new ArrayList<>();
        List<String> frontEndCrewsName = Files.readAllLines(Paths.get(
            "/Users/taehoon/Desktop/wooacourse_test/java-pairmatching-precourse/src/main/resources/frontend-crew.md"));
        for (String frontEndCrewName : frontEndCrewsName) {
            crews.add(new Crew(Course.FRONTEND, frontEndCrewName));
        }
        return crews;
    }
}
