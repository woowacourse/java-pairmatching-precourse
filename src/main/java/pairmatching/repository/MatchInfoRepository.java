package pairmatching.repository;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.MatchInfo;
import pairmatching.domain.Mission;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MatchInfoRepository {
    private static final MatchInfoRepository instance = new MatchInfoRepository();
    private static List<MatchInfo> matchInfoList = new ArrayList<>();

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
