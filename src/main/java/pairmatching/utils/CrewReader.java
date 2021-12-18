package pairmatching.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrewReader {

    private static final String DIR_PREFIX = "./src/main/resources/";
    private static final String BACKEND_CREW_FILE = DIR_PREFIX + "backend-crew.md";
    private static final String FRONTEND_CREW_FILE = DIR_PREFIX + "frontend-crew.md";
    private static final String ERR_FILE_NOT_EXIST = "파일이 존재하지 않습니다.";

    public static List<String> readBackendCrews() {
        return readCrewList(BACKEND_CREW_FILE);
    }

    public static List<String> readFrontEndCrews() {
        return readCrewList(FRONTEND_CREW_FILE);
    }


    private static List<String> readCrewList(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            List<String> names = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                names.add(line);
            }
            return names;
        } catch (IOException e) {
            ErrorPrinter.print(e);
            throw new IllegalArgumentException(fileName + " " + ERR_FILE_NOT_EXIST);
        }
    }
}
