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
    private PairService pairService;
    private InfoValidation infoValidation;

    public MainService(){
        this.pairService = new PairService();
        this.infoValidation = new InfoValidation();
    }
    public void match() {
        boolean runStatus = true;
        while(runStatus){
            try{
                printMainInfo();
                String input = InputView.input();
                infoValidation.checkInfo(input);
                String[] info = input.split(",");
                Course course = Course.ofName(info[0].trim());
                Level level = Level.of(info[1].trim());
                String missionName = info[2].trim();
                Mission mission = MissionRepository.findMissionByInfo(course,level,missionName);
                runStatus = pairService.makeMatching(course,level,mission);
            }catch (IllegalArgumentException | IOException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void getPairList(){
        boolean runStatus = true;
        while(runStatus){
            try{
                printMainInfo();
                String input = InputView.input();
                infoValidation.checkInfo(input);
                String[] info = input.split(",");
                Course course = Course.ofName(info[0].trim());
                Level level = Level.of(info[1].trim());
                String missionName = info[2].trim();
                Mission mission = MissionRepository.findMissionByInfo(course,level,missionName);
                runStatus = pairService.getPair(course,level,mission);
            }catch (IllegalArgumentException | IOException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void removePairList(){
        boolean runStatus = true;
        while(runStatus){
            try{
                printMainInfo();
                String input = InputView.input();
                infoValidation.checkInfo(input);
                String[] info = input.split(",");
                Course course = Course.ofName(info[0].trim());
                Level level = Level.of(info[1].trim());
                String missionName = info[2].trim();
                Mission mission = MissionRepository.findMissionByInfo(course,level,missionName);
                runStatus = pairService.removePair(course,level,mission);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

}
