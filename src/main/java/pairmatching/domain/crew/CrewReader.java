package pairmatching.domain.crew;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.ErrorMessage;
import pairmatching.domain.course.Course;

public class CrewReader {
    private final String locationOfBE = "./src/main/resources/backend-crew.md";
    private final String locationOfFE = "./src/main/resources/frontend-crew.md";

    private final String READER_ERROR = "error while reading file.";

    public List<Crew> readBECrewFromMd() {
        return readCrewFromLocation(locationOfBE, Course.BACKEND);
    }

    public List<Crew> readFECrewFromMd() {
        return readCrewFromLocation(locationOfBE, Course.BACKEND);
    }

    private List<Crew> readCrewFromLocation(String fileLocation, Course course) {
        ArrayList<Crew> crewList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
            String name;
            while ((name = reader.readLine()) != null) {
                crewList.add(new Crew(name, course));
            }
            reader.close();
        } catch (IOException e) {
            throw new IllegalArgumentException(ErrorMessage.makeErrorMessage(READER_ERROR));
        }
        return crewList;
    }
}
