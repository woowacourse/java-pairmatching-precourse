package pairmatching.repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
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
            throw new IllegalArgumentException("파일이 존재하지 않습니다.");
        }
    }

    public List<String> getBackendCrewName() {
        return Collections.unmodifiableList(backendCrewName);
    }

    public List<String> getFrontendCrewNames() {
        return Collections.unmodifiableList(frontendCrewNames);
    }
}
