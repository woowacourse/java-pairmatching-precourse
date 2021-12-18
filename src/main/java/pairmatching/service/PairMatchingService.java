package pairmatching.service;

import pairmatching.domain.*;

import java.util.ArrayList;
import java.util.List;

import static pairmatching.domain.Mission.getMissionFromNameAndLevel;
import static pairmatching.view.OutputView.printCourseAndMission;

public class PairMatchingService {

    private List<Pair> pairList = new ArrayList<>();
    private CrewService crewService = new CrewService();

    public void pairMatching() {
        Pair pair = getPairFromInput();

        pairList.add(pair);

        printPair(pair);
    }

    public void inquiryPair() {
        Pair pair = getPairFromInput();

        boolean contains = pairList.contains(pair);

        if (contains) {
            printPair(pair);
            return;
        }

        System.out.println("[ERROR] 매칭 이력이 없습니다.");
    }

    public void initPair() {
        pairList = new ArrayList<>();

        System.out.println("초기화 되었습니다.");
    }

    private void printPair(Pair pair) {
        System.out.println("페어 매칭 결과입니다.");

        pair.printPairInfo();
    }

    private Pair getPairFromInput() {
        String input = printCourseAndMission();

        String[] splitStrings = input.split(", ");

        Course course = Course.getCourseFromInput(splitStrings[0]);
        Level level = Level.getLevelFromInput(splitStrings[1]);
        Mission mission = getMissionFromNameAndLevel(splitStrings[2], level);

        List<Crew> crewList = crewService.createCrewList(course);

        Pair pair = new Pair(crewList, mission);

        return pair;
    }
}
