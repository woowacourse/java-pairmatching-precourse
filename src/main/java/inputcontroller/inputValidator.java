package inputcontroller;

import java.util.ArrayList;

public class inputValidator {

    public static ArrayList<String[]> level2Missions;

    public static void initLevel2Missions() {
        level2Missions = new ArrayList<>();
        level2Missions.set(1, new String[]{"자동차경주", "로또", "숫자야구게임"});
        level2Missions.set(2, new String[]{"장바구니", "결제", "지하철노선도"});
        level2Missions.set(4, new String[]{"성능개선", "배포"});
    }

    public static void isValidFunctionChoice(String inputText) {
        if (inputText.length() != 1) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력\n");
        }
        if (inputText.charAt(0) != '1' && inputText.charAt(0) != '2' && inputText.charAt(0) != '3' && inputText.charAt(0) != 'Q') {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력\n");
        }
    }

    public static void isValidCourseLevelMission(String[] inputTextParsed) {
        isValidCourseLevel(inputTextParsed);
        isValidMission(inputTextParsed);
    }

    public static void isValidCourseLevel(String[] inputTextParsed) {
        if (!inputTextParsed[0].equals("백엔드") || !inputTextParsed[0].equals("프론트엔드")) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력\n");
        }
        if (inputTextParsed[1].charAt(0) != '레') {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력\n");
        }
        if (inputTextParsed[1].charAt(1) != '벨') {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력\n");
        }
    }

    public static void isValidMission(String[] inputTextParsed) {
        if (inputTextParsed.length != 3) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력\n");
        }
        for (int i = 0; i < inputTextParsed.length; i++) {
            char ch = inputTextParsed[1].charAt(2);
            int idx = ch - '0';

            String mission = inputTextParsed[2];
            String[] missions = level2Missions.get(idx);
            checkMission(missions, mission);
        }
    }

    public static boolean checkMission(String[] missions, String mission) {
        for (int i = 0; i < missions.length; i++) {
            if (mission.equals(missions[i])) {
                return true;
            }
        }
        return false;
    }


}
