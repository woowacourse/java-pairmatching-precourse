package domain;

import java.util.List;

import validation.CheckCurriculumFormat;
import view.CurriculumBoard;
import view.InputView;
import view.OutputView;

public class OperationController {
    private static final String ERROR_MESSAGE = "[ERROR] 잘못된 형식으로 입력되었거나 미션이 없는 레벨을 선택하셨습니다.";
    
    public static void runMatchingManagement() {
        CurriculumBoard.showCurriculumBoard();
        operateMatching();
    }
    
    private static void operateMatching() {
        while(true) {
            String input = InputView.selectCurriculum();
            try {
                String [] info = input.split(",",-1); 
                validationForCurriculum(info);
                Course course = Course.findByName(info[0]);
                Level level = Level.findByName(info[1]);
                Mission mission = Level.findbyMissionName(level, info[2]);
                OperationService.runPairmatching(course, mission);
                OutputView.showMatchingResult(course, mission);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
        
    private static void validationForCurriculum(String [] info) {
        if(info.length < 3) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        CheckCurriculumFormat.checkCourse(info[0]);
        CheckCurriculumFormat.checkLevel(info[1]);
        
        if(info.length == 3) {
            CheckCurriculumFormat.checkMission(info[1], info[2]);
        }
    }

}
