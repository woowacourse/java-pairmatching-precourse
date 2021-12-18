package pairmatching.infomation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BackendCrewRepository {
    private static final ArrayList<Crew> backendCrews = new ArrayList<>();

    public static void initBackCrew () throws IOException {
        BufferedReader br = new BufferedReader(
                new FileReader("C:\\Users\\wotj1\\Desktop\\최종\\java-pairmatching-precourse\\" +
                        "src\\main\\resources\\backend-crew.md"));

        while(true) {
            String name = br.readLine();
            if (name == null) {
                break;
            }
            backendCrews.add(new Crew("백엔드", name));
        }
        br.close();
    }


    public static ArrayList<Crew> getBackendCrews() {
        return backendCrews;
    }
}
