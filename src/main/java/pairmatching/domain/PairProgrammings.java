package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;


public class PairProgrammings {

    private List<PairProgramming> pairProgrammings = new ArrayList<>();

    public void enrollNewProgram(String detailedFunction) {
        String[] detailedFunctions = detailedFunction.split(", ");
        String targetCourse = detailedFunctions[0];
        String targetLevel = detailedFunctions[1];
        String targetMission = detailedFunctions[2];

        pairProgrammings.add(new PairProgramming(targetCourse, targetLevel, targetMission));
    }
}
