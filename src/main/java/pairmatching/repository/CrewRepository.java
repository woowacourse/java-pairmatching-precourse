package pairmatching.repository;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static pairmatching.utils.ExceptionMessage.ERROR_FILE_READ;

public class CrewRepository {
    private static final CrewRepository instance = new CrewRepository();
    private static final Map<Course, List<Crew>> crews = new HashMap<>();


    private CrewRepository() {

    }
    public static CrewRepository getInstance() {
        return instance;
    }

    public void init() {
        try {
            readBackendCrew();
            readFrontendCrew();
        } catch (IOException e) {
            throw new IllegalArgumentException(ERROR_FILE_READ);
        }
    }

    private void readBackendCrew() throws IOException {
        List<Crew> crewList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(
                new FileReader("src/main/resources/backend-crew.md")
        );
        String str;
        while((str = reader.readLine()) != null) {
            crewList.add(new Crew(Course.BACKEND, str));
        }
        reader.close();
        crews.put(Course.BACKEND, crewList);
    }

    private void readFrontendCrew() throws IOException {
        List<Crew> crewList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(
                new FileReader("src/main/resources/frontend-crew.md")
        );
        String str;
        while((str = reader.readLine()) != null) {
            crewList.add(new Crew(Course.FRONTEND, str));
        }
        reader.close();
        crews.put(Course.FRONTEND, crewList);
    }

    public List<Crew> getCrew(Course course) {
        return crews.get(course);
    }
}
