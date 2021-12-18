package pairmatching.service;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.MissionRepository;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static camp.nextstep.edu.missionutils.Randoms.shuffle;
import static pairmatching.service.FileRead.fileRead;
import static pairmatching.view.Main.MainInfo.printMainInfo;

public class PairService {

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
                runStatus = makeMatching(course,level,mission);
            }catch (IllegalArgumentException | IOException e){

            }
        }
    }


    private List<String> makeCrewNameList(Course course) throws IOException {
        String file = null;
        if(course.equals(Course.BACKEND)){
            file = "/Users/guinness/java-pairmatching-precourse/src/main/resources/backend-crew.md";

        }

        if(course.equals(Course.FRONTEND)){
            file = "/Users/guinness/java-pairmatching-precourse/src/main/resources/frontend-crew.md";
        }

        BufferedReader reader = fileRead(file);
        String name;
        List<String> crewNameList = new ArrayList<>();
        while ((name = reader.readLine()) != null) {
            crewNameList.add(name);
        }
        reader.close();
        return crewNameList;
    }

    private void evenMatch(List<String> crewNameList ,Level level,Mission mission){
        int count = 0;
        while(count < 3){
            for(int i = 0; i < crewNameList.size()-1; i += 2){
                Crew crew1 =  CrewRepository.findByName(crewNameList.get(i));
                Crew crew2 = CrewRepository.findByName(crewNameList.get(i+1));
                if(!crew1.checkAlreadyPair(level,crew2) && !crew2.checkAlreadyPair(level,crew1)){
                    crew1.addAlreadyPair(level,crew2);
                    crew2.addAlreadyPair(level,crew1);
                    mission.addMatch(Arrays.asList(crew1,crew2));
                    continue;
                }
                count += 1;
                break;
            }
            OutputView.printMatching(mission);
            break;
        }
    }

    private void oddMatch(List<String> crewNameList ,Level level,Mission mission){
        int count = 0;
        while(count < 3){
            for(int i = 0; i < crewNameList.size()-3; i += 2){
                Crew crew1 =  CrewRepository.findByName(crewNameList.get(i));
                Crew crew2 = CrewRepository.findByName(crewNameList.get(i+1));
                if(!crew1.checkAlreadyPair(level,crew2) && !crew2.checkAlreadyPair(level,crew1)){
                    crew1.addAlreadyPair(level,crew2);
                    crew2.addAlreadyPair(level,crew1);
                    mission.addMatch(Arrays.asList(crew1,crew2));
                    continue;
                }
                count += 1;
                break;
            }

            Crew last1 = CrewRepository.findByName(crewNameList.get(crewNameList.size()-3));
            Crew last2 = CrewRepository.findByName(crewNameList.get(crewNameList.size()-2));
            Crew last3 = CrewRepository.findByName(crewNameList.get(crewNameList.size()-1));
            if(!last1.checkAlreadyPair(level,last2) && !last1.checkAlreadyPair(level,last3)){
                if(!last2.checkAlreadyPair(level,last1) && !last2.checkAlreadyPair(level,last3)){
                    if(!last3.checkAlreadyPair(level,last1) && !last3.checkAlreadyPair(level,last2)){
                        last1.addAlreadyPair(level,last2);
                        last1.addAlreadyPair(level,last3);
                        last2.addAlreadyPair(level,last1);
                        last2.addAlreadyPair(level,last3);
                        last3.addAlreadyPair(level,last1);
                        last3.addAlreadyPair(level,last2);
                        mission.addMatch(Arrays.asList(last1,last2,last3));
                    }
                }
            }

            OutputView.printMatching(mission);
            break;
        }
    }

    private boolean makeMatching(Course course, Level level, Mission mission) throws IOException {
        List<String> crewNameList = makeCrewNameList(course);
            crewNameList = shuffle(crewNameList);
            if(isEven(crewNameList)){
                evenMatch(crewNameList,level,mission);
            }

            if(!isEven(crewNameList)){
                oddMatch(crewNameList,level,mission);
            }
        return false;
    }


    private boolean isEven(List<String> list){
        if(list.size() % 2 == 0){
            return true;
        }
        return false;
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
                runStatus = getPair(course,level,mission);
            }catch (IllegalArgumentException | IOException e){

            }
        }
    }

    private boolean getPair(Course course, Level level, Mission mission) throws IOException {
        if (mission.isExistMatchingCrews()) {
            System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n" +
                    "네 | 아니오");
            String input = InputView.input();
            if (input.equals("네")) {
                mission.removeMatching();
                makeMatching(course, level, mission);
                return false;
            }
            mission.printPair();
            return false;
        }
        throw new IllegalArgumentException("[ERROR] 매칭 이력이 없습니다.");
    }
}
