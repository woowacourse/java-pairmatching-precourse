package pairmatching.service;

import pairmatching.domain.*;

import java.util.ArrayList;
import java.util.List;

import static pairmatching.domain.Course.*;
import static pairmatching.domain.Level.getLevelFromInput;
import static pairmatching.domain.Mission.getMissionFromNameAndLevel;
import static pairmatching.utils.VerificationUtil.validateExistPairInput;
import static pairmatching.view.OutputView.*;

public class PairMatchingService {

    private List<Pair> pairList = new ArrayList<>();
    private CrewService crewService = new CrewService();

    public void pairMatching() {
        printCourseAndMission();

        Pair pair = getPairFromInput();

        pairList.add(pair);

        printPair(pair);
    }

    public void inquiryPair() {
        Pair pair = getPairWithoutExistCheck();

        boolean contains = pairList.contains(pair);

        if (contains) {
            findAndPrint(pair);
            return;
        }

        System.out.println("[ERROR] 매칭 이력이 없습니다.");
    }

    public void initPair() {
        pairList = new ArrayList<>();

        System.out.println("초기화 되었습니다.");
    }

    private void findAndPrint(Pair getPair) {
        for (Pair pair : pairList) {
            if (pair.equals(getPair)) {
                printPair(pair);
                return;
            }
        }
    }

    private void printPair(Pair pair) {
        System.out.println("페어 매칭 결과입니다.");

        pair.printPairInfo();
    }

    private Pair getPairFromInput() {
        while (true) {
            try {
                String input = printInputCourseAndMission();

                String[] splitStrings = input.split(", ");

                Course course = getCourseFromInput(splitStrings[0]);
                Level level = getLevelFromInput(splitStrings[1]);
                Mission mission = getMissionFromNameAndLevel(splitStrings[2], level);

                List<Crew> crewList = crewService.createCrewList(course);

                Pair pair = new Pair(crewList, mission);

                checkPairExist(pair);

                return pair;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Pair getPairWithoutExistCheck() {
        while (true) {
            try {
                String input = printInputCourseAndMission();

                String[] splitStrings = input.split(", ");

                Course course = getCourseFromInput(splitStrings[0]);
                Level level = getLevelFromInput(splitStrings[1]);
                Mission mission = getMissionFromNameAndLevel(splitStrings[2], level);



                List<Crew> crewList = crewService.createCrewList(course);

                Pair pair = new Pair(crewList, mission);

                return pair;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void checkPairExist(Pair pair) {
        boolean contains = pairList.contains(pair);
        String input = "";

        if (contains) {
            input = getUserResponse();
        }

        if (input.equals("아니오")) {
            getPairFromInput();
            return;
        }

        if (input.equals("네")) {
            pairList.remove(pair);
            return;
        }
    }

    private String getUserResponse() {
        while (true) {
            try {
                String input = printExistPair();
                validateExistPairInput(input);

                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
