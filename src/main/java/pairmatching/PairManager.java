package pairmatching;

import java.util.ArrayList;

public class PairManager {
    CrewManager crewManager = new CrewManager();

    private ArrayList<Crew> setCrewList(String course) {
        if (course.equals("백엔드")) {
            return crewManager.getBackEndCrewList();
        }
        if (course.equals("프론트엔드")) {
            return crewManager.getFrontEndCrewList();
        }
        return null;
    }

    public void pairMatching(String course, String levelString, String mission) {
        ArrayList<Crew> crewList = setCrewList(course);
        int level = Integer.parseInt(levelString.substring(2));

    }

}
