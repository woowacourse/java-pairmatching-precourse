package pairmatching.model;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;


public class PairMatching {
    private static String course;
    private static String level;
    private static String mission;
    private static List<List<Crew>> pairPerson;

    PairMatching(String course, String level, String mission, List<List<Crew>> pairPerson) {
        this.course = course;
        this.level = level;
        this.mission = mission;
        this.pairPerson = pairPerson;
    }

    public static List<List<Crew>> getPairPerson() {
        return pairPerson;
    }

    public static String getCourse() {
        return course;
    }

    public static String getLevel() {
        return level;
    }

    public static String getMission() {
        return mission;
    }

    public static boolean createPairPerson(String course, String level, String mission){
        pairPerson = new ArrayList<>();
        List<Crew> shuffleList = null;
        if(course.equals("백엔드")){
           shuffleList = BackendCrew.getBackendCrewList();
        }else if (course.equals("프론트엔드")){
            shuffleList = BackendCrew.getBackendCrewList();
        }
        shuffleList = Randoms.shuffle(shuffleList);

        pairPerson = createPersonAdd(shuffleList);

        if(!PairMatchingList.existList(course, level, mission, pairPerson)){
            return false;
        }

        PairMatchingList.addList(course, level, mission, pairPerson);
        return true;
    }

    private static List<List<Crew>> createPersonAdd(List<Crew> shuffleList){
        for(int i=0; i<shuffleList.size()/2; i++){
            List<Crew> pair = new ArrayList<>();
            pair.add(shuffleList.get(i*2));
            pair.add(shuffleList.get((i*2)+1));
            if(shuffleList.size()%2 == 1 && i == shuffleList.size()/2-1){
                pair.add(shuffleList.get((i*2)+2));
            }
            pairPerson.add(pair);
        }
        return pairPerson;
    }

}
