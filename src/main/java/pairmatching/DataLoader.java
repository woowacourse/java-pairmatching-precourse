package pairmatching;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataLoader {
    private final Crews crews;

    public DataLoader() {
        crews = new Crews();
    }

    public Crews load() throws FileNotFoundException {
        List<String> backendCrews = loadBackendCrews();
        List<String> frontendCrews = loadFrontendCrews();

        initBackend(backendCrews);
        initFrontend(frontendCrews);

        return crews;
    }

    private void initBackend(List<String> backendCrews) {
        for (String backendCrew : backendCrews) {
            Crew crew = new Crew(Course.BACKEND, backendCrew);
            crews.addCrew(crew);
        }
    }

    private void initFrontend(List<String> frontendCrews) {
        for (String frontendCrew : frontendCrews) {
            Crew crew = new Crew(Course.FRONTEND, frontendCrew);
            crews.addCrew(crew);
        }
    }

    private List<String> loadBackendCrews() throws FileNotFoundException {
        List<String> backendCrews = new ArrayList<>();
        Scanner scanner = new Scanner(new File("src/main/resources/backend-crew.md"));
        while (scanner.hasNextLine()) {
            String name = scanner.nextLine();
            backendCrews.add(name);
        }
        return backendCrews;
    }

    private List<String> loadFrontendCrews() throws FileNotFoundException {
        List<String> frontendCrews = new ArrayList<>();
        Scanner scanner = new Scanner(new File("src/main/resources/frontend-crew.md"));
        while (scanner.hasNextLine()) {
            String name = scanner.nextLine();
            frontendCrews.add(name);
        }
        return frontendCrews;
    }


}
