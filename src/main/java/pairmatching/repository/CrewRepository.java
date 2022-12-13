package pairmatching.repository;

import static pairmatching.domain.Course.BACKEND;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import pairmatching.domain.Course;

public class CrewRepository {

    private static final List<String> backendNames;
    private static final List<String> frontendNames;


    static {
        try {
            backendNames = Files.readAllLines(Paths.get("src/main/resources/backend-crew.md"));
            frontendNames = Files.readAllLines(Paths.get("src/main/resources/frontend-crew.md"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> getNames(Course course) {
        if (BACKEND == course) {
            return CrewRepository.backendNames;
        }

        return CrewRepository.frontendNames;
    }
}
