package pairmatching.infomation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FrontendCrewRepository {
    private static final ArrayList<Crew> frontendCrews = new ArrayList<>();

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
            frontendCrews.add(new Crew("프론트엔드", name));
        }
        br.close();
    }

    public static ArrayList<Crew> getFrontendCrews() {
        return frontendCrews;
    }
}
