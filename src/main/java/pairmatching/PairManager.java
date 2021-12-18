package pairmatching;

import java.util.ArrayList;

public class PairManager {
    BackEndManager backEndManager = new BackEndManager();
    FrontEndManager frontEndManager = new FrontEndManager();

    private ArrayList<Crew> setCrewList(String course) {
        if (course.equals("백엔드")) {
            return backEndManager.getBackEndCrewList();
        }
        if (course.equals("프론트엔드")) {
            return frontEndManager.getFrontEndCrewList();
        }
        return null;
    }

    public void init(String course, String level, String mission) {

    }

    public void pairMatching(String course, String levelString, String mission) {

    }

}
