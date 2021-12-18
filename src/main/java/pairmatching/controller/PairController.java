package pairmatching.controller;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.model.MatchingInfo;
import pairmatching.model.Pair;
import pairmatching.model.enums.Course;
import pairmatching.model.enums.Level;
import pairmatching.utils.FileReader;
import pairmatching.utils.Validator;

import java.util.ArrayList;
import java.util.List;

import static pairmatching.view.InputView.inputDetails;
import static pairmatching.view.InputView.inputReMatch;

public class PairController {
    private final static String ERROR_OVER_TRY_CNT = "[ERROR] 매칭 시도 최대 횟수 초과";
    private final static String SEPARATOR = ",";
    private final static String ANSWER_YES = "네";
    private final static int MAX_TRY_CNT = 3;
    private final static int PAIR_CNT = 2;
    private final static Validator validator = new Validator();

    private List<MatchingInfo> matchingInfos;

    public PairController() {
    }

    public void selectMatchPair() {
        String[] arr = splitMatchingInfo(inputDetails());
        MatchingInfo matchingInfo = new MatchingInfo(arr[0], arr[1], arr[2]);
        if (!validator.isDuplicatedInfo(matchingInfos, matchingInfo)
                || inputReMatch().equals(ANSWER_YES)) {
            matchPair(matchingInfo);
        }
    }

    public void printPair() {

    }

    public void initialPair() {

    }

    private void matchPair(MatchingInfo matchingInfo) {
        FileReader fileReader = new FileReader(matchingInfo.getCourse().getName());
        List<String> members = fileReader.getNameList();
        List<Pair> pairHistory = getPairHistory(matchingInfo.getCourse(), matchingInfo.getLevel());

        for (int i = 0; i < MAX_TRY_CNT; i++) {
            List<Pair> pairs = getPairList(Randoms.shuffle(members), pairHistory);
            if (pairs != null) {
                matchingInfo.setMatchingPairs(pairs);
                return;
            }
        }

        throw new IllegalArgumentException(ERROR_OVER_TRY_CNT);
    }

    private List<Pair> getPairList(List<String> members, List<Pair> pairHistory) {
        List<Pair> pairs = new ArrayList<>();
        int size = members.size();
        for (int i = 0; i < size; i += PAIR_CNT) {
            Pair pair = new Pair(members.get(i), members.get(i + 1));
            if (isContainedPair(pairHistory, pair)) {
                return null;
            }
            pairs.add(pair);
        }
        if (size % PAIR_CNT != 0) {
            pairs.get(pairs.size() - 1).addMember(members.get(size - 1));
        }
        return pairs;
    }

    private boolean isContainedPair(List<Pair> pairs, Pair nowPair) {
        for (Pair pair : pairs) {
            if (pair.isEquals(nowPair)) {
                return true;
            }
        }
        return false;
    }

    private List<Pair> getPairHistory(Course course, Level level) {
        List<Pair> history = new ArrayList<>();
        for (MatchingInfo matchingInfo : matchingInfos) {
            if (!matchingInfo.isSameCourseAndLevel(course, level)) {
                continue;
            }
            history.addAll(matchingInfo.getMatchingPairs());
        }
        return history;
    }

    private String[] splitMatchingInfo(String input) {
        String[] arr = input.split(SEPARATOR);
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            arr[i] = arr[i].trim();
        }
        return arr;
    }
}
