package pairmatching.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pairmatching.utils.PairMatcher;
import pairmatching.view.FileInputView;

public class System {

    private List<Crew> backEndCrewList;
    private List<Crew> frontEndCrewList;
    private List<List<String>> backEndPairList;
    private List<List<String>> frontEndPairList;

    public System() throws IOException {
        backEndCrewList = getCrewList(FileInputView.readBackEndCrews(), Course.BACKEND);
        frontEndCrewList = getCrewList(FileInputView.readFrontEndCrews(), Course.FRONTEND);
    }

    public List<Crew> getCrewList(final List<String> crewNameList, final Course course) {
        List<Crew> crewList = new ArrayList<>();
        for (String crewName : crewNameList) {
            crewList.add(new Crew(crewName, course));
        }
        return crewList;
    }

    public void randomMatchBE() {
        backEndPairList = PairMatcher.randomMatch(getBECrewNameList());
    }

    public void randomMatchFE() {
        frontEndPairList = PairMatcher.randomMatch(getFECrewNameList());
    }

    public List<String> getBECrewNameList() {
        List<String> nameList = new ArrayList<>();
        backEndCrewList.forEach(crew -> nameList.add(crew.getName()));
        return nameList;
    }

    public List<String> getFECrewNameList() {
        List<String> nameList = new ArrayList<>();
        frontEndCrewList.forEach(crew -> nameList.add(crew.getName()));
        return nameList;
    }
}
