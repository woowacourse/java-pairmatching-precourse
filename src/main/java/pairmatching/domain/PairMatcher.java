package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.util.UnableToMatchException;

import java.util.ArrayList;
import java.util.List;

public class PairMatcher {

    private static final int DEFAULT_PAIR_SIZE = 2;
    private static final int EXCEPTIONAL_PAIR_SIZE = 3;
    private static final int INIT_INDEX = 0;
    private static final int INIT_MATCH_COUNT = 0;
    private static final int MAXIMUM_MATCH_COUNT = 3;
    private static final String UNABLE_TO_MATCH_ERROR = "[ERROR] 매칭 가능한 페어의 경우의 수가 없습니다.";

    private int matchCount = INIT_MATCH_COUNT;
    private List<String> crewNames;

    public PairMatcher(List<String> crewNames){
        this.crewNames = new ArrayList<>(crewNames);
    }

    public List<List<String>> match(){
        checkMatchCount();
        shuffleCrewNames();
        return matchPair();
    }

    private void checkMatchCount(){
        matchCount++;
        if(matchCount==MAXIMUM_MATCH_COUNT || matchCount == crewNames.size()-1){
            throw new UnableToMatchException(UNABLE_TO_MATCH_ERROR);
        }
    }

    private void shuffleCrewNames(){
        crewNames = Randoms.shuffle(crewNames);
    }

    private List<List<String>> matchPair(){
        List<List<String>> pair = new ArrayList<>();
        for(int i=INIT_INDEX; i<=crewNames.size()-DEFAULT_PAIR_SIZE; i+=DEFAULT_PAIR_SIZE){
            if(i==crewNames.size()-EXCEPTIONAL_PAIR_SIZE){
                pair.add(new ArrayList<>(crewNames.subList(i,i+EXCEPTIONAL_PAIR_SIZE)));
                break;
            }
            pair.add(new ArrayList<>(crewNames.subList(i,i+DEFAULT_PAIR_SIZE)));
        }
        return pair;
    }
}
