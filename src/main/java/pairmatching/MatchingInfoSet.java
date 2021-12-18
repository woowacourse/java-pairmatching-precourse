package pairmatching;

import java.util.HashMap;

public class MatchingInfoSet {
    public static class MatchingKey {
        public Course course;
        public Mission mission;

        public MatchingKey(Course course, Mission mission) {
            this.course = course;
            this.mission = mission;
        }
    }

    private HashMap<MatchingKey, MatchingInfo> allMatchingInfo = new HashMap<>();

    public MatchingInfoSet() {
        for (Course c : Course.values()) {
            for (Mission m : Mission.values()) {
                MatchingKey key = new MatchingKey(c, m);
                MatchingInfo info = new MatchingInfo();
                allMatchingInfo.put(key, info);
            }
        }
    }

    public void performPairMatching(String missionString) {
        MatchingInfo matchingInfo = getMissionInfo(missionString);
        if(matchingInfo.existInfo()){
            System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
            System.out.println("네 | 아니오");
            boolean rematch=InputManager.getAnswer();
            if(!rematch){
                return;
            }
        }
        matchingInfo.match();
    }

    private MatchingInfo getMissionInfo(String missionString) {
        MatchingKey key = InputManager.getMissionKey(missionString);
        if (allMatchingInfo.containsKey(key)) {
            return allMatchingInfo.get(key);
        }
        throw new IllegalArgumentException();
    }

    public void viewPairMatching(String missionString) {
        MatchingInfo missionInfo = getMissionInfo(missionString);
    }
}
