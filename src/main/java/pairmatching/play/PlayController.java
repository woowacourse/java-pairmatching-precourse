package pairmatching.play;

import pairmatching.Validation;
import pairmatching.course.Level;
import pairmatching.course.StoreMission;
import pairmatching.crew.CrewController;

import java.io.IOException;
import java.util.*;

import static pairmatching.course.Course.*;

public class PlayController {
    private PlayView playView;
    private String input;
    private StoreMission storeMission;
    private CrewController crewController;

    public PlayController() throws IOException {
        playView = new PlayView();
        storeMission = new StoreMission();
        storeMission.storePerLevelMission();
        crewController = new CrewController();
        crewController.storeCrew();
    }

    public void playGame() {
        playView.showMenuView();
        this.input = checkInputNumAndPlay();
        boolean result; // 게임이 끝나면 true 반환 후 종료
        while (true){
            result = playPairProgrammming(this.input);
            if(result){
                break;
            }
            playGame();
        }
    }

    public boolean playPairProgrammming(String input) {
        if(input.equals("1")) {
            showNum1View();
        }
        if(input.equals("2")) {
            System.out.println("2번게임 시작");
            System.out.println();
        }
        if(input.equals("3")) {
            System.out.println("3번게임 시작");
            System.out.println();
        }
        if(input.equals("Q")) {
            return true;
        }
        return false;
    }



    public String checkInputNumAndPlay() {
        String input = "";
        try {
            input = playView.inputString();
            Validation.checkInputForm(input);
        }catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 1,2,3,Q 중 하나를 입력해주세요");
            input = checkInputNumAndPlay();
        }
        return input;
    }

    public void showNum1View() {
        playView.num1InputView();
        String inputCourse = playView.inputString();
        // 예외 처리 해주기 -> 일단 나중에 우선 옳은 값이 들어왔다고 가정하고
        String[] inputArray = inputCourse.split(", ");
        matchingCrew(inputArray);
    }

    public void matchingCrew(String[] inputArray) {
        if(inputArray[0].equals("백엔드")) {
            backendMatching(inputArray);
        }
        if(inputArray[0].equals("프론트엔드")) {
        }
    }

    public void backendMatching(String[] inputArray) {
        List<Level> back = BACKEND.getLevelList(); // 백엔드마다 레벨 리스트
        for(Level l : back) {

        }
    }
}
