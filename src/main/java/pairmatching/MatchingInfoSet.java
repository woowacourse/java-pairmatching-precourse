package pairmatching;

import java.util.HashMap;
import java.util.List;

public class MatchingInfoSet {
    public static class MatchingKey {
        public Course course;
        public String mission;

        public MatchingKey(Course course, String mission) {
            this.course = course;
            this.mission = mission;
        }

        public boolean isBackend(){
            if(course==Course.BACKEND){
                return true;
            }
            return false;
        }

    }

    private HashMap<MatchingKey, MatchingInfo> allMatchingInfo = new HashMap<>();

    public MatchingInfoSet() {}

    public void performPairMatching(String missionString) {
        MatchingKey key=InputManager.getMissionKey(missionString);
        MatchingInfo info=new MatchingInfo();
        if(allMatchingInfo.containsKey(key)) {
            System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
            System.out.println("네 | 아니오");
            boolean rematch=InputManager.getAnswer();
            if(!rematch){
                return;
            }
            info=allMatchingInfo.get(key);
        }
        info.match(key.isBackend());
    }

    public void viewPairMatching(String missionString) {
        MatchingKey key=InputManager.getMissionKey(missionString);

        if(allMatchingInfo.containsKey(key)) {
            allMatchingInfo.get(key).printMatchingInfo();
            return;
        }
        System.out.println("[ERROR] 매칭 이력이 없습니다.");
    }
}
