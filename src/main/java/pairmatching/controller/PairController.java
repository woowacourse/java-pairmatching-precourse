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

import static pairmatching.utils.constants.InputConstants.MATCHING_RESULT_GUIDE;
import static pairmatching.view.InputView.inputDetails;
import static pairmatching.view.InputView.inputReMatch;

public class PairController {
    private final static String ERROR_OVER_TRY_CNT = "[ERROR] 매칭 시도 최대 횟수 초과";
    private final static String INITIAL_COMPLETE = "초기화 되었습니다.";
    private final static String SEPARATOR = ",";
    private final static String ANSWER_YES = "네";
    private final static int MAX_TRY_CNT = 3;
    private final static int PAIR_CNT = 2;
    private final static Validator validator = new Validator();

    private List<MatchingInfo> matchingInfos = new ArrayList<>();

    public PairController() {
    }

    public void selectMatchPair() {
        MatchingInfo matchingInfo = getNewMatchingInfo();
        if (!validator.isDuplicatedInfo(matchingInfos, matchingInfo)
                || inputReMatch().equals(ANSWER_YES)) {
            try {
                matchPair(matchingInfo);
                printPairResult(matchingInfo);
                matchingInfos.add(matchingInfo);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void selectPair() {
        MatchingInfo nowMatchingInfo = getNewMatchingInfo();
        if (matchingInfos == null) {
            return;
        }
        for (MatchingInfo matchingInfo : matchingInfos) {
            if (matchingInfo.isSameMatching(nowMatchingInfo)) {
                printPairResult(matchingInfo);
                return;
            }
        }
    }

    public void initialPair() {
        MatchingInfo matchingInfo = getNewMatchingInfo();
        if (matchingInfos != null && removeMatchingInfo(matchingInfo)) {
            System.out.println(INITIAL_COMPLETE);
        }
    }

    private boolean removeMatchingInfo(MatchingInfo matchingInfo) {
        int size = matchingInfos.size();
        for (int i = 0; i < size; i++) {
            if (matchingInfos.get(i).isSameMatching(matchingInfo)) {
                matchingInfos.remove(i);
                return true;
            }
        }
        return false;
    }

    private MatchingInfo getNewMatchingInfo() {
        String[] arr = splitMatchingInfo(inputDetails());
        return new MatchingInfo(arr[0], arr[1], arr[2]);
    }

    private void printPairResult(MatchingInfo matchingInfo) {
        System.out.println(MATCHING_RESULT_GUIDE);
        System.out.println(matchingInfo.toString());
    }

    private void matchPair(MatchingInfo matchingInfo) {
        FileReader fileReader = new FileReader(matchingInfo.getCourse().getFileName());
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
        if (matchingInfos == null) {
            return history;
        }
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
