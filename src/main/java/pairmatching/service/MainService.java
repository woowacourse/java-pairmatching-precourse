package pairmatching.service;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.repository.MissionRepository;
import pairmatching.view.InputView;

import java.io.IOException;

import static pairmatching.view.Main.MainInfo.printMainInfo;

public class MainService {
    private PairService pairService;

    public MainService(){
        this.pairService = new PairService();
    }
    public void match() {
        boolean runStatus = true;
        while(runStatus){
            try{
                printMainInfo();
                String input = InputView.input();
                // Validation
                String[] info = input.split(",");
                Course course = Course.ofName(info[0].trim());
                Level level = Level.of(info[1].trim());
                String missionName = info[2].trim();
                Mission mission = MissionRepository.findMissionByInfo(course,level,missionName);
                runStatus = pairService.makeMatching(course,level,mission);
            }catch (IllegalArgumentException | IOException e){

            }
        }
    }

    public void getPairList(){
        boolean runStatus = true;
        while(runStatus){
            try{
                printMainInfo();
                String input = InputView.input();
                // Validation
                String[] info = input.split(",");
                Course course = Course.ofName(info[0].trim());
                Level level = Level.of(info[1].trim());
                String missionName = info[2].trim();
                Mission mission = MissionRepository.findMissionByInfo(course,level,missionName);
                runStatus = pairService.getPair(course,level,mission);
            }catch (IllegalArgumentException | IOException e){

            }
        }
    }

    public void removePairList(){
        boolean runStatus = true;
        while(runStatus){
            try{
                printMainInfo();
                String input = InputView.input();
                // Validation
                String[] info = input.split(",");
                Course course = Course.ofName(info[0].trim());
                Level level = Level.of(info[1].trim());
                String missionName = info[2].trim();
                Mission mission = MissionRepository.findMissionByInfo(course,level,missionName);
                runStatus = pairService.removePair(course,level,mission);
            }catch (IllegalArgumentException e){
            }
        }
    }
}
