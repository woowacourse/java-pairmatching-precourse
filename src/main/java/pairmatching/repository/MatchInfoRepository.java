package pairmatching.repository;

import pairmatching.domain.Crew;
import pairmatching.domain.MatchInfo;

import java.util.ArrayList;
import java.util.List;

public class MatchInfoRepository {
    private static final MatchInfoRepository instance = new MatchInfoRepository();
    private static final List<MatchInfo> matchInfoList = new ArrayList<>();

    private MatchInfoRepository() {
    }

    public static MatchInfoRepository getInstance() {
        return instance;
    }

    public MatchInfo addMatchInfo(MatchInfo matchInfo) {
        matchInfoList.add(matchInfo);
        return matchInfo;
    }




}
