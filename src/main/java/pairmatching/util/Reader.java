package pairmatching.util;

import pairmatching.view.message.ErrorMessage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    public static final String backendCrew = "src/main/resources/backend-crew.md";
    public static final String frontendCrew = "src/main/resources/frontend-crew.md";

    public static List<String> readCrewName(String path) {
        List<String> crewNames = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String str;

            while ((str = reader.readLine()) != null) {
                crewNames.add(str);
            }
            reader.close();
        } catch (Exception exception) {
            System.out.println(ErrorMessage.ERROR_CANNOT_READ_FILE.getMessage());
        }
        return crewNames;
    }
}
