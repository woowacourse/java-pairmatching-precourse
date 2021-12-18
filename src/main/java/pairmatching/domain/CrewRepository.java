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

    public static void addFrontendCrew(Crew crew) {
        frontendCrewList.add(crew);
    }

    public static List<List<String>> makeBackendPair() {
        List<String> nameList = shuffleBackendCrew();
        return makePairs(nameList);
    }

    public static List<List<String>> makeFrontendPair() {
        List<String> nameList = shuffleFrontendCrew();
        return makePairs(nameList);
    }

    private static List<List<String>> makePairs(List<String> nameList) {
        List<List<String>> pairList = new ArrayList<>();
        int i = 0;
        for(; i < nameList.size() - 1; i+=2) {
            List<String> pair = new ArrayList<>();
            pair.add(nameList.get(i));
            pair.add(nameList.get(i+1));
            pairList.add(pair);
        }
        if(i != nameList.size()) {
            pairList.get(pairList.size()-1).add(nameList.get(i));
        }
        return pairList;
    }

    public static List<String> shuffleBackendCrew() {
        List<String> nameList = getBackendCrewNames();
        return Randoms.shuffle(nameList);
    }

    public static List<String> shuffleFrontendCrew() {
        List<String> nameList = getFrontendCrewNames();
        return Randoms.shuffle(nameList);
    }

    public static List<String> getBackendCrewNames() {
        return backendCrewList.stream().map(crew -> crew.getName()).collect(Collectors.toList());
    }

    public static List<String> getFrontendCrewNames() {
        return frontendCrewList.stream().map(crew -> crew.getName()).collect(Collectors.toList());
    }
}
