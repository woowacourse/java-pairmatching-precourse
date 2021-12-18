package pairmatching.service;

import pairmatching.domain.*;

import java.util.ArrayList;
import java.util.List;

public class PairMatchingService {

    private List<Pair> pairList = new ArrayList<>();

    public void pairMatching() {
        String input = "";
        CrewService crewService = new CrewService();

        Course course = Course.getCourseFromInput(input);
        Level level = Level.getLevelFromInput(input);

        List<Crew> crewList = crewService.createCrewList(course);

        String missionName = "";

        Mission mission = new Mission(missionName, level);

        Pair pair = new Pair(crewList, mission);

        pairList.add(pair);

        printPair(pair);
    }


    public void printPair(Pair pair) {
        System.out.println("페어 매칭 결과입니다.");

        pair.printPairInfo();

    }

    public void initPair() {
        pairList = new ArrayList<>();

        System.out.println("초기화 되었습니다.");
    }
}
