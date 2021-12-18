package pairmatching.infomation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CrewRepository {
    private static final ArrayList<Crew> crews = new ArrayList<>();

    public static void initBackCrew () throws IOException {
        BufferedReader br = new BufferedReader(
                new FileReader("C:\\Users\\wotj1\\Desktop\\최종\\java-pairmatching-precourse\\" +
                        "src\\main\\resources\\backend-crew.md"));

        while(true) {
            String name = br.readLine();
            if (name == null) {
                break;
            }
            crews.add(new Crew("백엔드", name));
        }
        br.close();
    }

    public static void initFrontCrew () throws IOException {
        BufferedReader br = new BufferedReader(
                new FileReader(
                        "C:\\Users\\wotj1\\Desktop\\최종\\java-pairmatching-precourse\\" +
                                "src\\main\\resources\\frontend-crew.md"));

        while(true) {
            String name = br.readLine();
            if (name == null) {
                break;
            }
            crews.add(new Crew("프론트엔드", name));
        }
        br.close();
    }

    public static ArrayList<Crew> getCrews() {
        return crews;
    }
}
