package pairmatching.controller;

import pairmatching.domain.Crews;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CrewInformationController {
    private static final String ERROR_WRONG_INFO = "[ERROR] 잘못된 정보입니다.";

    public static void readCrews(Crews pairmatching) {
        String backendNames = "src/main/resources/backend-crew.md";
        String frontendNames = "src/main/resources/frontend-crew.md";

        try {
            Stream<String> streamBackend = Files.lines(Paths.get(backendNames));
            streamBackend.forEach(name -> pairmatching.inputBackendCrew(name));

            Stream<String> streamFrontend = Files.lines(Paths.get(frontendNames));
            streamFrontend.forEach(name -> pairmatching.inputFrontendCrew(name));
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_WRONG_INFO);
        }
    }
}
