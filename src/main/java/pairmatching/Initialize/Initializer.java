package pairmatching.Initialize;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.repository.CrewRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Initializer {
    public void setBackCrew() throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader("/Users/guinness/java-pairmatching-precourse/src/main/resources/backend-crew.md")
        );
        String name;
        while ((name = reader.readLine()) != null) {
            CrewRepository.addCrew(new Crew(name, Course.BACKEND));
        }
        reader.close();
    }

    public void setFrontCrew() throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader("/Users/guinness/java-pairmatching-precourse/src/main/resources/frontend-crew.md")
        );
        String name;
        while ((name = reader.readLine()) != null) {
            CrewRepository.addCrew(new Crew(name,Course.FRONTEND));
        }
        reader.close();
    }

}
