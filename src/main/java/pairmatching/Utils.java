package pairmatching;

import camp.nextstep.edu.missionutils.Console;

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
            // 페어 조회
        }
        if (answer.equals("3")) {
            // 페어 초기화
        }
        if (!(answer.equals("1")||answer.equals("2")||answer.equals("3")||answer.equals("Q"))) {
            Except.StartPageError();
        }
    }

    public static void InputPairMatching() {
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");
        String[] answer = Console.readLine().split(", ");
        if (answer.length == 3 && Course.JudgeCourse(answer[0])
                && Level.JudgeLevel(answer[1], answer[2])) {
            PrintPage.StartPage();
        }
        Except.PairMatchingInputError();
    }

    public static void BackEndCrewInput() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("./src/main/resources/backend-crew.md"));
            while(true) {
                String line = br.readLine();
                if (line==null) break;
                backendCrew.add(new Crew(line));
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
            }
            br.close();
        } catch (Exception e) {
            System.out.println("[ERROR] : 프론트엔드 명단이 이상해요");
        }
    }
}
