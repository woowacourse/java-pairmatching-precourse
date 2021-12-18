package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.utils.Validator;

public class PairMatchingInput{

    public static String[] choiceMatchingInformation() {
        PairMatchingOutput.matchInstruction();
        String information = Console.readLine();
        Validator.validateInformationFormat(information);
        String[] matchingInformation = information.split(",");
        Validator.validateInformationContent(matchingInformation);
        return matchingInformation;
    }
}
