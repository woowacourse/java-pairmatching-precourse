package pairmatching.repository;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static pairmatching.utils.ExceptionMessage.ERROR_FILE_READ;

public class CrewRepository {
    private static final CrewRepository instance = new CrewRepository();
    private static final List<Crew> crews = new ArrayList<>();


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
        BufferedReader reader = new BufferedReader(
                new FileReader("src/main/resources/backend-crew.md")
        );
        String str;
        while((str = reader.readLine()) != null) {
            crews.add(new Crew(Course.BACKEND, str));
        }
        reader.close();
    }

    private void readFrontendCrew() throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader("src/main/resources/frontend-crew.md")
        );
        String str;
        while((str = reader.readLine()) != null) {
            crews.add(new Crew(Course.FRONTEND, str));
        }
        reader.close();
    }
}
