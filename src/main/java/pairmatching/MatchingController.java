package pairmatching;

import pairmatching.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MatchingController {
    private static InputView inputView = new InputView();
    private static final String BACKEND_FILE_NAME = "backend-crew.md";
    private static final String FRONTEND_FILE_NAME = "frontend-crew.md";

    private MissionList backendMissionList;
    private MissionList frontEndMissionList;

    public void run() {
        init();
        doSelectionNumber();

    }

    private void init() {
        List<Crew> allCrewsList = getAllCrewsList();
        backendMissionList = new MissionList(inputView.getCrewFromFile(BACKEND_FILE_NAME, Course.BACKEND));
        frontEndMissionList = new MissionList(inputView.getCrewFromFile(FRONTEND_FILE_NAME, Course.FRONTEND));
    }

    private void doSelectionNumber() {
        while (true){
            String selectionNumber = inputView.inputSelectionNumber();
            if (selectionNumber.equals("1")) {
                String[] missionInfo = inputView.getMissionInfo();
                String course = missionInfo[0];
                String level = missionInfo[1];
                String MissionName = missionInfo[2];
                pairMatching(checkCourse(course), level, MissionName);
            }
            if (selectionNumber.equals("Q")){
                return;
            }
        }
    }

    private void pairMatching(MissionList missionList, String level, String missionName) {
        Mission mission = missionList.getMission(level, missionName);
        if (mission.checkMatchingHistory()) {
            int cnt = 0;
            if(inputView.checkReMatchingInput()){
                mission.pairMathingList(missionList, checkLevel(level));
            }
            return;
        }

    }

    private MissionList checkCourse(String courseName) {
        if (courseName.contains("백엔드")){
            return backendMissionList;
        }
        return frontEndMissionList;
    }

    private Level checkLevel(String levelName) {
        for (Level level : Level.values()) {
            if(level.name().equals(levelName)){
                return level;
            }
        }
        return null;
    }

    private List<Crew> getAllCrewsList(){
        List<Crew> allCrews = new ArrayList<>();
        List<Crew> backendCrews = inputView.getCrewFromFile(BACKEND_FILE_NAME, Course.BACKEND);
        List<Crew> frontEndCrews = inputView.getCrewFromFile(FRONTEND_FILE_NAME, Course.FRONTEND);
        allCrews.addAll(backendCrews);
        allCrews.addAll(frontEndCrews);
        return allCrews;
    }

}
