package pairmatching.domain;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CrewRepository {

    private static final List<Crew> crews = new ArrayList<>();

    public static List<Crew> getCrews() { return crews; }

    public static void addCrew(Crew crew) {
        crews.add(crew);
    }

    public static void initCrewDatabase() {
        for (String crewName : Objects.requireNonNull(readCrewNames("frontend-crew.md"))) {
            addCrew(new Crew(crewName, Course.FRONTEND));
        }
        for (String crewName : Objects.requireNonNull(readCrewNames("backend-crew.md"))) {
            addCrew(new Crew(crewName, Course.BACKEND));
        }
    }

    public static List<String> readCrewNames(String resourceName) {
        try {
            URL resource = CrewRepository.class.getClassLoader().getResource(resourceName);
            assert resource != null;
            Path path = new File(resource.getPath()).toPath();
            return Files.readAllLines(path);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
