package pairmatching;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NameReader {

    public static final String FRONTEND_CREW_FILE_LOCATION = "src/main/resources/frontend-crew.md";
    public static final String BACKEND_CREW_FILE_LOCATION = "src/main/resources/backend-crew.md";

    private NameReader(){};

    public static List<String> readCrewName(String location) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(location));
        List<String> crewNameList = new ArrayList<>();
        while (scanner.hasNext()) {
            crewNameList.add(scanner.next().trim());
        }

        return crewNameList;

    }

    public static String getFileLocation(Course course) {
        if (course == Course.BACKEND) {
            return BACKEND_CREW_FILE_LOCATION;
        }
        return FRONTEND_CREW_FILE_LOCATION;
    }
}
