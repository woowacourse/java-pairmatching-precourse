package pairmatching;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputManager {

    public InputManager() {
    }

    public static boolean getAnswer(){
        while(true){
            String answer=readLine();
            if(answer.equals("네")){
                return true;
            }
            if(answer.equals("아니오")){
                return false;
            }
            System.out.println("[ERROR] 예 또는 아니오로 입력해주세요.");
        }
    }
    public static MatchingInfoSet.MatchingKey getMissionKey(String missionString) {
        String[] missionList = missionString.split(",");

        checkMissionListSize(missionList);
        String courseName = missionList[0];
        String levelName = missionList[1];
        String missionName = missionList[2];

        Course course = Course.valueOf(courseName);
        Mission mission = Mission.valueOf(missionName);
        mission.checkLevel(levelName);

        return new MatchingInfoSet.MatchingKey(course, mission);
    }

    private static void checkMissionListSize(String[] missionList) {
        if (missionList.length != 3) {
            throw new IllegalArgumentException();
        }
    }

}
