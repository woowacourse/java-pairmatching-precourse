package pairmatching;

import java.util.Arrays;

import pairmatching.controller.PairMatchingController;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.PairResult;
import pairmatching.domain.PairResults;
import pairmatching.utill.CrewFileReader;

public class Application {
    public static void main(String[] args) {
        PairMatchingController pairMatchingController = new PairMatchingController();
        pairMatchingController.runPairMatching();
    }
}
