package pairmatching;

import java.util.ArrayList;

public enum Mission {
    BACK_CAR("백엔드","레벨1","자동차경주"),
    BACK_LOTTO("백엔드","레벨1","로또"),
    BACK_BASEBALL("백엔드","레벨1", "숫자야구게임"),
    BACK_BUCKET("백엔드","레벨2","장바구니"),
    BACK_PAY("백엔드","레벨2","결제"),
    BACK_SUBWAY("백엔드","레벨2","지하철 노선도"),
    BACK_LEVEL3("백엔드","레벨3"),
    BACK_REFORM("백엔드","레벨4", "성능개선"),
    BACK_DISTRIBUTE("백엔드","레벨4", "배포"),
    BACK_LEVEL5("백엔드","레벨5"),

    FRONT_CAR("프론트엔드","레벨1","자동차경주"),
    FRONT_LOTTO("프론트엔드","레벨1","로또"),
    FRONT_BASEBALL("프론트엔드","레벨1", "숫자야구게임"),
    FRONT_BUCKET("프론트엔드","레벨2","장바구니"),
    FRONT_PAY("프론트엔드","레벨2","결제"),
    FRONT_SUBWAY("프론트엔드","레벨2","지하철 노선도"),
    FRONT_LEVEL3("프론트엔드","레벨3"),
    FRONT_REFORM("프론트엔드","레벨4", "성능개선"),
    FRONT_DISTRIBUTE("프론트엔드","레벨4", "배포"),
    FRONT_LEVEL5("프론트엔드","레벨5");

    private String level;
    private String missionName = "";
    private Course end;
    private static ArrayList<Crew> attendanceBook = new ArrayList<>();

    Mission(String end, String level, String missionName) {
        this.level = level;
        this.missionName = missionName;
        if (end.equals("백엔드")) {
            this.end = Course.BACKEND;
        }
        if (end.equals("프론트엔드")) {
            this.end = Course.BACKEND;
        }
    }

    Mission(String end ,String level) {
        this.level = level;
        if (end.equals("백엔드")) {
            this.end = Course.BACKEND;
        }
        if (end.equals("프론트엔드")) {
            this.end = Course.BACKEND;
        }
    }

    public static void AddCrewList(String missionName,ArrayList<Crew> Crew) {
        for (Mission mission : Mission.values()) {
            if (mission.missionName.equals(missionName)) {
                mission.MakeAttendanceBook(Crew);
            }
        }
    }

    public static void CheckTheMissionForPrint(String end,String missionName) {
        for (Mission mission : Mission.values()) {
            if (mission.missionName.equals(missionName) && (mission.end == Course.setName(end))) {
                mission.PrintPair();
            }
        }
        Except.NotFoundMatching();
    }

    public void PrintPair() {
        for (int i = 1; i < attendanceBook.size(); i++) {
            if (i == attendanceBook.size() - 1) {
                System.out.println(" : " + attendanceBook.get(i));
            }
            if (i != attendanceBook.size() - 1 && i % 2 == 1) {
                System.out.print(attendanceBook.get(i));
            }
            if (i != attendanceBook.size() - 1 && i % 2 == 0) {
                System.out.print(" : " + attendanceBook.get(i));
            }
            if (i != attendanceBook.size() - 2 && i % 2 == 0) {
                System.out.println(" : " + attendanceBook.get(i));
            }
        }
    }

    public static void ClearPair() {
        for (Mission mission : Mission.values()) {
            mission.attendanceBook = new ArrayList<>();
        }
    }

    public boolean MakeAttendanceBook(ArrayList<Crew> CrewList) {
        if (attendanceBook.size() == 0) {
            attendanceBook = new ArrayList<>();
            attendanceBook.addAll(CrewList);
            return true;
        }
        return false;
    }

}
