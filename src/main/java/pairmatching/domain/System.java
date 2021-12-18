package pairmatching.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pairmatching.view.FileInputView;

public class System {

    private List<Crew> backEndCrewList;
    private List<Crew> frontEndCrewList;

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
}
