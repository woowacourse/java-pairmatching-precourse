package pairmatching.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pairmatching.utils.PairMatcher;
import pairmatching.view.FileInputView;

public class System {

    private static final String BACKEND = "백엔드";
    private static final String FRONTEND = "프론트엔드";

    private List<Crew> backEndCrewList;
    private List<Crew> frontEndCrewList;
    private List<MatchingInfo> matchingInfos;

    public System() throws IOException {
        backEndCrewList = getCrewList(FileInputView.readBackEndCrews(), Course.BACKEND);
        frontEndCrewList = getCrewList(FileInputView.readFrontEndCrews(), Course.FRONTEND);
        matchingInfos = new ArrayList<>();
    }

    public List<Crew> getCrewList(final List<String> crewNameList, final Course course) {
        List<Crew> crewList = new ArrayList<>();
        for (String crewName : crewNameList) {
            crewList.add(new Crew(crewName, course));
        }
        return crewList;
    }

    public void randomMatch(final String courseName, final String level, final String mission) {
        Course course = Course.getCourse(courseName);
        matchingInfos.add(
            new MatchingInfo(PairMatcher.randomMatch(getCrewNameList(course)), course, Level.getLevel(level), mission));
    }

    public List<String> getCrewNameList(final Course course) {
        if (course == Course.BACKEND) {
            List<String> nameList = new ArrayList<>();
            backEndCrewList.forEach(crew -> nameList.add(crew.getName()));
            return nameList;
        }
        if (course == Course.FRONTEND) {
            List<String> nameList = new ArrayList<>();
            frontEndCrewList.forEach(crew -> nameList.add(crew.getName()));
            return nameList;
        }
        throw new IllegalArgumentException();
    }

    public MatchingInfo getMatchingInfo(final Course course, final Level level, final String mission) {
        return matchingInfos.stream()
            .filter(v -> v.equals(course, level, mission))
            .findFirst()
            .orElseThrow(IllegalAccessError::new);
    }

    public void initializeMatchingInfos() {
        while (!matchingInfos.isEmpty()) {
            matchingInfos.remove(0);
        }
    }
}
