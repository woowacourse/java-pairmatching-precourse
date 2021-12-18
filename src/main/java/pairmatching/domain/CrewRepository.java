package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class CrewRepository {
    List<Crew> backendCrewList = new ArrayList<>();
    List<Crew> frontendCrewList = new ArrayList<>();

    public void addBackendCrew(Crew crew) {
        backendCrewList.add(crew);
    }

    public List<String> getBackendCrewNames() {
        return null;
    }

    public void addFrontendCrew(Crew crew) {
        frontendCrewList.add(crew);
    }

    public List<String> getFrontendCrewNames() {
        return null;
    }
}
