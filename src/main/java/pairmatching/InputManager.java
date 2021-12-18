package pairmatching;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputManager {

    public InputManager() {
    }

    public static boolean getAnswer() {
        while (true) {
            String answer = readLine();
            if (answer.equals("네")) {
                return true;
            }
            if (answer.equals("아니오")) {
                return false;
            }
            System.out.println("[ERROR] 예 또는 아니오로 입력해주세요.");
        }
    }

    public static MatchingInfoSet.MatchingKey getMissionKey(String missionString) {
        String[] missionList = missionString.split(", ");

        Course course = Course.of(missionList[0]);
        Level level = Level.of(missionList[1]);
        String missionName = missionList[2];

        level.checkMissionLevel(missionName);
        return new MatchingInfoSet.MatchingKey(course, missionName);
    }

    private static void checkMissionListSize(String[] missionList) {
        if (missionList.length != 3) {
            System.out.println("[ERROR] 과정, 레벨, 미션 형식에 맞게 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

}
