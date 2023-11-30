package pairmatching.controller;

import static pairmatching.exception.ErrorCode.INVALID_NUMBER_INPUT;
import static pairmatching.view.input.InputView.InputChooseNumber;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import pairmatching.view.ouput.ErrorOutputWriter;

public class MainPairMatchingController {
    private MainPairMatchingController(){
    }

    public static void start(){
        Map<String, Consumer<String>> functions = new HashMap<>();
        functions.put("1", PairMatchingController::pairMatching);
        functions.put("2", PairInquiryController::pairInquiry);
        functions.put("3", PairResetController::pairReset);

        while (true) {
            String input = InputChooseNumber();
            if ("Q".equals(input)) {
                break;
            }
            functions.getOrDefault(input, ErrorOutputWriter::invalidInput).accept(input);
        }
    }
}
