package pairmatching.service;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.repository.MissionRepository;
import pairmatching.validation.InfoValidation;
import pairmatching.view.InputView;

import java.io.IOException;

import static pairmatching.view.Main.MainInfo.printMainInfo;

public class MainService {
    private ManagementService managementService;
    private InfoValidation infoValidation;

    public MainService() {
        this.managementService = new ManagementService();
        this.infoValidation = new InfoValidation();
    }

    private String printMainInfoAndValidate(){
        printMainInfo();
        String input = InputView.input();
        infoValidation.checkInfo(input);
        return input;
    }

    public void match() {
        boolean runStatus = true;
        while (runStatus) {
            try {
                String input = printMainInfoAndValidate();
                String[] info = input.split(",");
                Course course = Course.ofName(info[0].trim());
                Level level = Level.of(info[1].trim());
                String missionName = info[2].trim();
                Mission mission = MissionRepository.findMissionByInfo(course, level, missionName);
                runStatus = managementService.makeMatching(course, level, mission);
            } catch (IllegalArgumentException | IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void getPairList() {
        boolean runStatus = true;
        while (runStatus) {
            try {
                String input = printMainInfoAndValidate();
                String[] info = input.split(",");
                Course course = Course.ofName(info[0].trim());
                Level level = Level.of(info[1].trim());
                String missionName = info[2].trim();
                Mission mission = MissionRepository.findMissionByInfo(course, level, missionName);
                runStatus = managementService.getPair(course, level, mission);
            } catch (IllegalArgumentException | IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void removePairList() {
        boolean runStatus = true;
        while (runStatus) {
            try {
                String input = printMainInfoAndValidate();
                String[] info = input.split(",");
                Course course = Course.ofName(info[0].trim());
                Level level = Level.of(info[1].trim());
                String missionName = info[2].trim();
                Mission mission = MissionRepository.findMissionByInfo(course, level, missionName);
                runStatus = managementService.removePair(course, level, mission);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
