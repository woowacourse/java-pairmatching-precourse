package pairmatching;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CrewNameReader {

    public static void getBackendCrewNames() {
        List<String> crewNames = getCrewNames("backend-crew.md");
    }

    public static void getFrontendCrewNames() {
        List<String> crewNames = getCrewNames("frontend-crew.md");
    }


    private static List<String> getCrewNames(String fileName) {
        List<String> crewNames = new ArrayList<>();
        FileInputStream file = null;
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(CrewNameReader.class.getClassLoader().getResource("backend-crew.md").getFile())));
            String str;
            while ((str = br.readLine()) != null) {
                crewNames.add(str);
            }
            return crewNames;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
