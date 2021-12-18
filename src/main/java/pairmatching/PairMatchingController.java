package pairmatching;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public class PairMatchingController {

    public static final String BACKEND_CREW_NAMES = "src/main/resources/backend-crew.md";
    public static final String FRONTEND_CREW_NAMES = "src/main/resources/frontend-crew.md";

    public void run() {
        List<String> backendCrewNames = loadBackendCrewName()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 파일이 존재하지 않습니다."));

        List<String> frontendCrewNames = loadFrontendCrewName()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 파일이 존재하지 않습니다."));
    }


    private Optional<List<String>> loadBackendCrewName() {
        try {
            Path path = Paths.get(BACKEND_CREW_NAMES);
            List<String> crewNames = Files.readAllLines(path);
            return Optional.of(crewNames);
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    private Optional<List<String>> loadFrontendCrewName() {
        try {
            Path path = Paths.get(FRONTEND_CREW_NAMES);
            List<String> crewNames = Files.readAllLines(path);
            return Optional.of(crewNames);
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
