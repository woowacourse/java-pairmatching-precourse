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
        PairMatchingOutput.matchInstruction();
        String[] information = inputInformation();
        try {
            Pair pair = pairMatching.addPairInPairListOfLevel(information[0], information[1], information[2]);
            PairMatchingOutput.printPair(pair);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public String[] inputInformation() {
        String[] information;
        boolean rematch = false;
        do{
            information = PairMatchingInput.choiceMatchingInformation();
            if(pairMatching.checkIfPairResultAlreadyExist(information[0], information[1], information[2])){
                rematch = PairMatchingInput.inputForRematch();
            }
        } while (rematch);

        return information;
    }

    public void search() {

    }

    public void initialize() {
        pairMatching.initialize();
    }
}
