package pairmatching.view;

import java.util.LinkedHashMap;

import pairmatching.domain.Crew;
import pairmatching.domain.ProgramInfo;

public class OutputView {
    public static void showThisProgramPair(ProgramInfo programInfo) {
        LinkedHashMap<Crew, Crew> pairs = programInfo.getPairs();
        for (Crew crew : pairs.keySet()) {
            System.out.println(crew + " : " + pairs.get(crew));
        }
    }
}
