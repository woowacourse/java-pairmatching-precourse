package pairmatching.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.InitialSetting;
import pairmatching.model.*;
import pairmatching.validator.Validator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.List;

public class PairController {
    private InputView inputView = new InputView();
    private InitialSetting initialSetting = new InitialSetting();
    private OutputView outputView = new OutputView();
    private Validator validator = new Validator();

    public void run() {
        initialSetting.initialInformation();
        initialSetting.getFileNameInDirectory();
        while(selectMenu()){

        }

    }

    public boolean selectMenu() {
        try {
            inputView.printSelectMenu();
            String selectMenu = Console.readLine();
            validator.validateSelectMenu(selectMenu);
            if (selectMenu.equals("1")) {
                pairMatch();
            }
            if (selectMenu.equals("2")) {
                getPair();
            }
            if (selectMenu.equals("3")) {
                initialPair();
            }
            if (selectMenu.equals("Q")) {
                return false;
            }
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            selectMenu();
        }
        return true;
    }

    public void pairMatch() {
        try {
            outputView.printInformation();
            inputView.inputInformation();
            String inputInformation = Console.readLine();
            String[] splitInformation = validator.validateCountComma(inputInformation);
            Course course = validator.validateCourse(splitInformation[0]);
            Level level = validator.validateLevel(splitInformation[1]);
            Mission mission = validator.validateMission(level, splitInformation[2]);
            inputPair(course, mission);
            outputView.printPairList(course, mission);
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            pairMatch();
        }
    }

    public void getPair() {
        try {
            outputView.printInformation();
            inputView.inputInformation();
            String inputInformation = Console.readLine();
            String[] splitInformation = validator.validateCountComma(inputInformation);
            Course course = validator.validateCourse(splitInformation[0]);
            Level level = validator.validateLevel(splitInformation[1]);
            Mission mission = validator.validateMission(level, splitInformation[2]);
            validator.validateExistPairList(course, mission);
            outputView.printPairList(course, mission);
        }catch (IllegalArgumentException exception){
            outputView.printError(exception.getMessage());
        }
    }

    public void initialPair() {

    }

    public void inputPair(Course course, Mission mission) {
        List<String> crewList = shuffleStringCrew(course);
        PairList pairList = new PairList();
        for (int idx = 0; idx < crewList.size(); idx += 2) {
            Pair pair = new Pair(crewList.get(idx), crewList.get(idx + 1));
            if (crewList.size() % 2 == 1 && idx == crewList.size() - 2) {
                pair.addPair(crewList.get(crewList.size() - 1));
                pairList.addPair(pair);
                break;
            }
            pairList.addPair(pair);
        }
        mission.addPairMap(course, pairList);
    }

    public List<String> shuffleStringCrew(Course course) {
        return Randoms.shuffle(course.getStringCrewList());
    }
}
