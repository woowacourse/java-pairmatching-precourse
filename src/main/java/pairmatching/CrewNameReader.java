package pairmatching;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CrewNameReader {

    public static List<String> getBackendCrewNames() {
       return getCrewNames("backend-crew.md");
    }

    public static List<String> getFrontendCrewNames() {
        List<String> crewNames = getCrewNames("frontend-crew.md");
        return crewNames;
    }

    private static List<String> getCrewNames(String fileName) {
        List<String> crewNames = new ArrayList<>();
        FileInputStream file = null;
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(CrewNameReader.class.getClassLoader().getResource(fileName).getFile())));
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
