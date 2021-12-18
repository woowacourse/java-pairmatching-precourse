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

    public static String getMissionInput() {
        String missionInput=readLine();
        checkMissionInput(missionInput);
        return missionInput;
    }

    public static boolean isBackend(String missionInput){
        if(missionInput.startsWith("백엔드")){
            return true;
        }
        return false;
    }

    private static void checkMissionInput(String missionInput){
        String[] missionList = missionInput.split(", ");
        checkMissionListSize(missionList);

        Course course = Course.of(missionList[0]);
        Level level = Level.of(missionList[1]);
        String missionName = missionList[2];
        level.checkMissionLevel(missionName);
    }

    private static void checkMissionListSize(String[] missionList) {
        if (missionList.length != 3) {
            throw new IllegalArgumentException();
        }
    }

}
