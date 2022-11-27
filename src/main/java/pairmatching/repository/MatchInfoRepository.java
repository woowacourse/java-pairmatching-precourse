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

    public MatchInfo reviseMatchInfo(MatchInfo info) {
        int index = 0;
        int removeIndex = 0;
        for (MatchInfo matchInfo : matchInfoList) {
            if (info.getCourse() == matchInfo.getCourse() && info.getLevel() == matchInfo.getLevel()
                    && info.getMission() == matchInfo.getMission()) {
                removeIndex = index;
            }
            index++;
        }
        matchInfoList.remove(removeIndex);
        matchInfoList.add(info);
        return info;
    }
    public boolean isExist(Course course, Level level, Mission mission) {
        List<MatchInfo> result = matchInfoList.stream()
                .filter(matchInfo -> course == matchInfo.getCourse())
                .filter(matchInfo -> level == matchInfo.getLevel())
                .filter(matchInfo -> mission == matchInfo.getMission())
                .collect(Collectors.toList());
        if (result.size() == 1) {
            return true;
        }
        return false;
    }
}
