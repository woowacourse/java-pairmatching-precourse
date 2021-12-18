package pairmatching.view;

import pairmatching.model.Crew;
import pairmatching.model.CrewList;

public abstract class OutputView {
    private static Crew crew;
    private static CrewList crewList;

    public static void printRandomPairList() {
        System.out.println("페어 매칭 결과입니다.");
//        Crew crew = new Crew();
//        System.out.println(crew.makeRandomPair());
    }


}
