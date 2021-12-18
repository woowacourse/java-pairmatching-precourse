package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CrewRepository {
    private static List<Crew> backendCrewList = new ArrayList<>();
    private static List<Crew> frontendCrewList = new ArrayList<>();

    public static void addBackendCrew(Crew crew) {
        backendCrewList.add(crew);
    }

    public static List<String> getBackendCrewNames() {
        return backendCrewList.stream().map(crew -> crew.getName()).collect(Collectors.toList());
    }

    public static void addFrontendCrew(Crew crew) {
        frontendCrewList.add(crew);
    }

    public static List<String> getFrontendCrewNames() {
        return frontendCrewList.stream().map(crew -> crew.getName()).collect(Collectors.toList());
    }

    public static List<String> shuffleBackendCrew() {
        List<String> nameList = getBackendCrewNames();
        return Randoms.shuffle(nameList);
    }

    public static List<String> shuffleFrontendCrew() {
        List<String> nameList = getFrontendCrewNames();
        return Randoms.shuffle(nameList);
    }

//    public static void printBackend() {
//        System.out.println("printBackend");
//        for(Crew crew : backendCrewList) {
//            System.out.println(crew.getName());
//        }
//    }
//    public static void printFront() {
//        System.out.println("printFrontEnd");
//        for(Crew crew : frontendCrewList) {
//            System.out.println(crew.getName());
//        }
//    }
}
