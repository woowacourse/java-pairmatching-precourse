package pairmatching;

import java.util.ArrayList;

public enum Mission {
    CAR("레벨1","자동차경주"),
    LOTTO("레벨1","로또"),
    BASEBALL("레벨1", "숫자야구게임"),
    BUCKET("레벨2","장바구니"),
    PAY("레벨2","결제"),
    SUBWAY("레벨2","지하철 노선도"),
    LEVEL3("레벨3"),
    REFORM("레벨4", "성능개선"),
    DISTRIBUTE("레벨4", "배포"),
    LEVEL5("레벨5");

    private String level;
    private String missionName = "";
    private static ArrayList<Crew> attendanceBook = new ArrayList<>();

    Mission(String level, String missionName) {
        this.level = level;
        this.missionName = missionName;
    }

    Mission(String level) {
        this.level = level;
    }

    public static void ClearPair() {
        for (Mission mission : Mission.values()) {
            attendanceBook = new ArrayList<>();
        }
    }

    public static boolean CheckTheAttendanceBook(ArrayList<Crew> CrewList) {

        return true;
    }

    public static boolean MakeAttendanceBook(ArrayList<Crew> CrewList) {
        if (attendanceBook.size() == 0) {
            attendanceBook = new ArrayList<>();
            attendanceBook.addAll(CrewList);
            return true;
        }
        return false;
    }

}
