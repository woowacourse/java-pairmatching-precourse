package pairmatching.domain.matcher;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.ErrorMessage;
import pairmatching.domain.crew.Crew;

public class Matcher {
    private final String ERROR_PAIR_NOT_ALLOWED = "짝 생성 오류.";
    private final int MAX_TRY_MATCH = 3;
    private final int NORMAL_PAIR = 2;
    private final int NORMAL_PAIR_EXCEPTION = 3;

    private PairHistory pairHistory;
    private Pairs pairs;
    private List<Crew> crews = new ArrayList<>();
    private int matchCount = 0;

    public PairController getPairsRandomly(List<Crew> crewList) {
        pairHistory = new PairHistory(crewList);
        loadCrewList(crewList);
        tryMatching();

        return new PairController(pairHistory,pairs);
    }

    public void tryMatching() {
        if (matchCount >= 3) {
            throw new IllegalArgumentException(ErrorMessage.makeErrorMessage("경우의 수 불가, 페어 매칭이 불가합니다..."));
        }
        while (isPickableFromFront()) {
            shuffleAll();
            List<Crew> pair = pickPairFromFront();
            if (!isNewToEachCrew(pair)) {
                matchCount++;
                tryMatching();
            }
            setHistoryThatPairHasMet(pair);
            pairs.addPair(pair);
        }
    }

    public void shuffleAll() {
        crews = Randoms.shuffle(crews);
    }

    public void loadCrewList(List<Crew> crewList) {
        crews.addAll(crewList);
    }

    public void deleteAll() {
        crews.clear();
    }

    private boolean isNewToEachCrew(List<Crew> pair) {
        checkValidPair(pair);
        if (pair.size() == NORMAL_PAIR) {
            if (pairHistory.isCrewAndCrewMeet(pair.get(0), pair.get(1))) {
                return true;
            }
        }
        if (pair.size() == NORMAL_PAIR_EXCEPTION) {
            if (pairHistory.isCrewAndCrewMeet(pair.get(0), pair.get(1)) ||
                pairHistory.isCrewAndCrewMeet(pair.get(1), pair.get(2)) ||
                pairHistory.isCrewAndCrewMeet(pair.get(0), pair.get(2))) {
                return true;
            }
        }
        return false;
    }

    private void setHistoryThatPairHasMet(List<Crew> pair) {
        checkValidPair(pair);
        if (pair.size() == NORMAL_PAIR) {
            pairHistory.setCrewAndCrewMet(pair.get(0), pair.get(1));
        }
        if (pair.size() == NORMAL_PAIR_EXCEPTION) {
            pairHistory.setCrewAndCrewMet(pair.get(0), pair.get(1));
            pairHistory.setCrewAndCrewMet(pair.get(1), pair.get(2));
            pairHistory.setCrewAndCrewMet(pair.get(0), pair.get(2));

        }
    }

    private List<Crew> pickPairFromFront() {
        ArrayList<Crew> pair = new ArrayList<>();
        pair.add(crews.get(0));
        pair.add(crews.get(1));
        crews.remove(0);
        crews.remove(0);

        if (crews.size() < NORMAL_PAIR && !crews.isEmpty()) {
            pair.add(crews.get(0));
            crews.remove(0);
        }
        return pair;
    }

    private boolean isPickableFromFront() {
        return (crews.size() >= NORMAL_PAIR);
    }

    private void checkValidPair(List<Crew> pair) {
        if (pair.size() != NORMAL_PAIR && pair.size() != NORMAL_PAIR_EXCEPTION) {
            throw new IllegalArgumentException(ErrorMessage.makeErrorMessage(
                ERROR_PAIR_NOT_ALLOWED));
        }
    }
}