package pairmatching.repository;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CrewRepository {
    private static final String resourcePath = "src/main/resources/";
    private final List<String> backendCrewName;
    private final List<String> frontendCrewNames;

    public CrewRepository() {
        try {
            BufferedReader backendFile =
                    new BufferedReader(new FileReader(resourcePath + "backend-crew.md"));
            BufferedReader frontendFile =
                    new BufferedReader(new FileReader(resourcePath + "frontend-crew.md"));
            backendCrewName = backendFile.lines().toList();
            frontendCrewNames = frontendFile.lines().toList();
        } catch (FileNotFoundException e) {
            //todo
            throw new IllegalArgumentException(e);
        }
    }
}
