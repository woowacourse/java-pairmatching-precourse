package pairmatching.controller;

import static pairmatching.view.input.InputView.inputChooseNumber;

import java.util.HashMap;
import java.util.Map;

public class MainPairMatchingController {
    private MainPairMatchingController(){
    }

    public static void start(){
        Map<String, Runnable> functions = new HashMap<>();
        functions.put("1", PairMatchingController::pairMatching);
        functions.put("2", PairInquiryController::pairInquiry);
        functions.put("3", PairResetController::pairReset);

        while (true) {
            String input = inputChooseNumber();
            if ("Q".equals(input)) {
                break;
            }

            Runnable function = functions.get(input);
            if (function != null) {
                 function.run();
            } else {
                System.out.println("유효하지 않은 입력입니다. 다시 입력해주세요.");
            }
        }
    }
}
