package pairmatching.controller;
import pairmatching.domain.Pair;
import pairmatching.domain.PairMatching;
import pairmatching.view.PairMatchingInput;
import pairmatching.view.PairMatchingOutput;

import java.io.IOException;

public class PairMatchingController {
    private PairMatching pairMatching = new PairMatching();

    public int inputFunction() {
        return 0;
    }

    public void match(){
        String[] information = PairMatchingInput.choiceMatchingInformation();
        Pair pair = pairMatching.addPairInPairListOfLevel(information[0], information[1], information[2]);
        PairMatchingOutput.printPair(pair);
    }

    public void search() {

    }

    public void initialize() {
        pairMatching.initialize();
    }
}
