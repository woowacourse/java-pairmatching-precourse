package pairmatching.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.exception.ExceptionMessage;

public class MDParser {

    private static final String BACKEND_FILE_PATH = "src/main/resources/backend-crew.md";
    private static final String FRONTEND_FILE_PATH = "src/main/resources/frontend-crew.md";

    public List<String> parserCrewData(Course course) {
        List<String> crewNames = new ArrayList<>();
        try {
            if (course == Course.BACKEND) {
                crewNames = parseData(BACKEND_FILE_PATH);
            }
            if (course == Course.FRONTEND) {
                crewNames = parseData(FRONTEND_FILE_PATH);
            }
        } catch (IOException e) {
            System.out.println(ExceptionMessage.PARSER_ERROR.getMessage());
        }
        return crewNames;
    }

    private List<String> parseData(String filePath) throws IOException {
        List<String> crewNames = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        while (true) {
            String name = bufferedReader.readLine();
            if (name == null) {
                break;
            }
            crewNames.add(name);
        }
        bufferedReader.close();
        return crewNames;
    }
}
