package pairmatching.controller;

import pairmatching.domain.Crews;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CrewInformationController {
    public static void readCrews(Crews pairmatching) {
        String backendNames = "src/main/resources/backend-crew.md";
        String frontendNames = "src/main/resources/frontend-crew.md";

        try {
            Stream<String> streamBackend = Files.lines(Paths.get(backendNames));
            streamBackend.forEach(name -> pairmatching.inputBackendCrew(name));

            Stream<String> streamFrontend = Files.lines(Paths.get(frontendNames));
            streamFrontend.forEach(name -> pairmatching.inputFrontendCrew(name));
        }
        catch (Exception e) {
            System.out.println("[Error] An error occurred.");
            e.printStackTrace();
        }
    }
}
