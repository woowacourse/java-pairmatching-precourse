package pairmatching.utils;

import pairmatching.model.MatchingInfo;
import pairmatching.model.Pair;
import pairmatching.model.enums.Course;
import pairmatching.model.enums.Level;

import java.util.List;

import static pairmatching.model.enums.Option.*;
import static pairmatching.utils.constants.ErrorConstants.*;

public class Validator {
    private final static String YES = "네";
    private final static String NO = "아니오";
    private final static String SEPARATOR = ",";
    private final static int INPUT_DETAIL_CNT = 3;
    private final static int NEGATIVE_NUMBER = -1;

    public Validator() {
    }

    public void checkValidOption(String input) {
        if (MATCH_PAIR.getValue().equals(input)
                || SELECT_PAIR.getValue().equals(input)
                || INITIAL_PAIR.getValue().equals(input)
                || QUIT.getValue().equalsIgnoreCase(input)) {
            return;
        }
        throw new IllegalArgumentException(ERROR_INPUT_OPTION);
    }

    public void checkValidDetails(String input) {
        String[] details = input.split(SEPARATOR, NEGATIVE_NUMBER);
        if (details.length == INPUT_DETAIL_CNT
                && isValidPrecourse(details[0].trim())
                && isValidLevel(details[1].trim())
                && isValidMission(details[1].trim(), details[2].trim())) {
            return;
        }
        throw new IllegalArgumentException(ERROR_INPUT_DETAILS);
    }

    public boolean isDuplicatedInfo(List<MatchingInfo> matchingInfoList, MatchingInfo nowMatchingInfo) {
        if (matchingInfoList == null) {
            return false;
        }
        for (MatchingInfo matchingInfo : matchingInfoList) {
            if (matchingInfo.isSameMatching(nowMatchingInfo)) {
                return true;
            }
        }
        return false;
    }

    public void checkReMatch(String input) {
        if (YES.equals(input) || NO.equals(input)) {
            return;
        }
        throw new IllegalArgumentException(ERROR_INPUT_REMATCH);
    }

    public boolean isContainedPair(List<Pair> pairs, Pair nowPair) {
        for (Pair pair : pairs) {
            if (pair.isEquals(nowPair)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidPrecourse(String input) {
        return Course.isContained(input);
    }

    private boolean isValidLevel(String input) {
        return Level.isContainedLevel(input);
    }

    private boolean isValidMission(String level, String mission) {
        return Level.isContainedMission(level, mission);
    }
}