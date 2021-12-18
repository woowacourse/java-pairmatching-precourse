package pairmatching;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Utils {
    public static ArrayList<Crew> backendCrew = new ArrayList<>();
    public static ArrayList<Crew> frontendCrew = new ArrayList<>();
    public static ArrayList<String> backendAttendanceBook = new ArrayList<>();
    public static ArrayList<String> frontendAttendanceBook = new ArrayList<>();

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

    public static boolean InputPairMatching() {
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");
        String[] answer = Console.readLine().split(", ");
        if (answer.length == 3 && Course.JudgeCourse(answer[0])
                && Level.JudgeLevel(answer[1], answer[2])) {
            return true;
        }
        Except.PairMatchingInputError();
        return false;
    }

    public static void BackEndCrewInput() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("./src/main/resources/backend-crew.md"));
            while(true) {
                String line = br.readLine();
                if (line==null) break;
                backendCrew.add(new Crew(line));
                backendAttendanceBook.add(line);
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
                frontendCrew.add(new Crew(line));
                frontendAttendanceBook.add(line);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("[ERROR] : 프론트엔드 명단이 이상해요");
        }
    }

    public static void ShuffleCrew(String end) {
        if (end.equals("백엔드")) {
            Randoms.shuffle(backendAttendanceBook);
        }
        if (end.equals("프론트엔드")) {
            Randoms.shuffle(frontendAttendanceBook);
        }
    }

    public static void PairReset() {
        System.out.println("초기화 되었습니다.");
        PrintPage.StartPage();
    }
}
