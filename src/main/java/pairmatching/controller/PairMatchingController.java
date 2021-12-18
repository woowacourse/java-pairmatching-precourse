package pairmatching.controller;
import pairmatching.domain.Pair;
import pairmatching.domain.PairMatching;
import pairmatching.utils.Validator;
import pairmatching.view.PairMatchingInput;
import pairmatching.view.PairMatchingOutput;

public class PairMatchingController {
    private PairMatching pairMatching = new PairMatching();

    public int inputFunctionNumber() {
        boolean again = false;
        int function = -1;
        do {
            try{
                function = PairMatchingInput.inputNumberToExecute();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                again = true;
            }
        } while (again);
        return function;
    }

    public void match(){
        PairMatchingOutput.matchInstruction();
        String[] information = inputInformationForMatch();
        try {
            Pair pair = pairMatching.addPairInPairListOfLevel(information[0], information[1], information[2]);
            PairMatchingOutput.printPair(pair);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private String[] inputInformationForMatch() {
        String[] information = null;
        boolean rematch = false;
        do{
            try{
                information = PairMatchingInput.choiceMatchingInformation();
                if(getPairResultIfExist(information)!= null){
                    rematch = PairMatchingInput.inputForRematch();
                }
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                rematch = true;
            }
        } while (rematch);

        return information;
    }

    public void search() {
        PairMatchingOutput.matchInstruction();
        try {
            String[] information = PairMatchingInput.choiceMatchingInformation();
            Pair pair = getPairResultIfExist(information);
            Validator.ValidateMatchingHistory(pair);
            PairMatchingOutput.printPair(pair);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }


    private Pair getPairResultIfExist(String[] information) {
        return pairMatching.getPairResult(information[0], information[1], information[2]);
    }

    public void initialize() {
        pairMatching.initialize();
    }
}
