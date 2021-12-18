package pairmatching;

import pairmatching.view.MatchingProgramInterface;
import pairmatching.view.classes.MatchingProgram;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        MatchingProgramInterface matchingProgramInterface = new MatchingProgram();
        matchingProgramInterface.start();
    }
}
