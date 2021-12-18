package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class CrewRepository {
    private static List<Crew> backendCrewList = new ArrayList<>();
    private static List<Crew> frontendCrewList = new ArrayList<>();

    public static void addBackendCrew(Crew crew) {
        backendCrewList.add(crew);
    }

    public static List<String> getBackendCrewNames() {
        return null;
    }

    public static void addFrontendCrew(Crew crew) {
        frontendCrewList.add(crew);
    }

    public static List<String> getFrontendCrewNames() {
        return null;
    }

    public static void printBackend() {
        System.out.println("printBackend");
        for(Crew crew : backendCrewList) {
            System.out.println(crew.getName());
        }
    }
    public static void printFront() {
        System.out.println("printFrontEnd");
        for(Crew crew : frontendCrewList) {
            System.out.println(crew.getName());
        }
    }
}
