package pairmatching.validator;

import java.util.ArrayList;

import static pairmatching.constant.ErrorMessage.NOT_CONTAIN_CHOICE_ERROR_MESSAGE;
import static pairmatching.constant.ErrorMessage.NOT_FORMAT_ERROR_MESSAGE;
import static pairmatching.constant.SystemMessage.*;

public class InputViewValidator {
    public static void checkUserChoice(String userChoice) {
        ArrayList<String> choice = new ArrayList<>();
        choice.add(PAIR_MATCHING_NUMBER);
        choice.add(PAIR_SHOW_NUMBER);
        choice.add(PAIR_INIT_NUMBER);
        choice.add(QUIT_SIGN);

        if (!choice.contains(userChoice)) {
            throw new IllegalArgumentException(NOT_CONTAIN_CHOICE_ERROR_MESSAGE);
        }
    }

    public static void checkProcessLevelMission(String processLevelMission) {
        String[] split = processLevelMission.split(", ");
        if (split.length != 3) {
            throw new IllegalArgumentException(NOT_FORMAT_ERROR_MESSAGE);
        }
    }
}
