package pairmatching;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Utils {
    public static ArrayList<Crew> backendCrew = new ArrayList<>();
    public static ArrayList<Crew> frontendCrew = new ArrayList<>();

    public static void InputStartMenu() {
        String answer = Console.readLine();
        Utils.SelectFunction(answer);
    }

    public static void SelectFunction(String answer) {
        if (answer.equals("1")) {
            PrintPage.PairMatching();
        }
        if (answer.equals("2")) {
            PrintPage.PrintMatching();
        }
        if (answer.equals("3")) {
            PairReset();
        }
        if (!(answer.equals("1")||answer.equals("2")||answer.equals("3")||answer.equals("Q"))) {
            Except.StartPageError();
        }
    }

    public static void InputPairMatching() {
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");
        String[] answer = Console.readLine().split(", ");
        if (answer.length == 3 && Course.JudgeCourse(answer[0]) && Level.JudgeLevel(answer[1], answer[2])) {
            return;
        }
        if (answer.length == 2 && Course.JudgeCourse(answer[0]) && Level.JudgeLevel(answer[1])) {
            return;
        }
        Except.PairMatchingInputError();
    }

    public static void InputPrintPair() {
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");
        String[] answer = Console.readLine().split(", ");
        if (answer.length == 3 && Course.JudgeCourse(answer[0]) && Level.JudgeLevel(answer[1], answer[2])) {
            Mission.CheckTheMissionForPrint(answer[0],answer[2]);
            return;
        }
        if (answer.length == 2 && Course.JudgeCourse(answer[0]) && Level.JudgeLevel(answer[1])) {
            Mission.CheckTheMissionForPrint(answer[0],answer[1]);
            return;
        }
        Except.PrintPairInputError();
    }

    public static void BackEndCrewInput() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("./src/main/resources/backend-crew.md"));
            while(true) {
                String line = br.readLine();
                if (line==null) break;
                backendCrew.add(new Crew(Course.BACKEND,line));
            }
            br.close();
        } catch (Exception e) {
            System.out.println("[ERROR] : 백엔드 명단이 이상해요");
        }
    }

    public static void frontEndCrewInput() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("./src/main/resources/frontend-crew.md"));
            while(true) {
                String line = br.readLine();
                if (line==null) break;
                frontendCrew.add(new Crew(Course.FRONTEND,line));
            }
            br.close();
        } catch (Exception e) {
            System.out.println("[ERROR] : 프론트엔드 명단이 이상해요");
        }
    }

    public static void ShuffleCrew(String end, String level,String missionName) {
        if (end.equals("백엔드")) {
            BackendMakePartnerThreeTime(level);
            Mission.CheckTheMissionForPrint(end,missionName);
            Mission.AddCrewList(missionName,backendCrew);
        }
        if (end.equals("프론트엔드")) {
            Randoms.shuffle(frontendCrew);
        }
    }

    public static void PairReset() {
        Mission.ClearPair();
        System.out.println("초기화 되었습니다.");
        PrintPage.StartPage();
    }

    public static void BackendMakePartnerThreeTime(String level) {
        int i = 0;
        while (i < 3) {
            i++;
            Randoms.shuffle(backendCrew);
            if (BackendMakePartner(level)) {
                break;
            }
        }
        Except.MatchingTryThreeTime();
    }

    public static boolean BackendMakePartner(String level) {
        ArrayList<String> tempAttendanceBook = new ArrayList<>();
        for (int i = 1; i < backendCrew.size()/2 ;i++) {
            return false;
        }
        return true;
    }


    public static void BackendCheckCrewName(String level, String mission, String name) {
        for (Crew crew : backendCrew) {
            if (crew.CheckMyName(name)) {
                crew.PartnerCheck(level,mission);
            }
        }
    }

}
