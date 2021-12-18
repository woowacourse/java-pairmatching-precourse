package pairmatching.Initialize;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.MissionRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static pairmatching.service.FileRead.fileRead;

public class Initializer {
    public void setBackCrew() throws IOException {
        BufferedReader reader = fileRead("/Users/guinness/java-pairmatching-precourse/src/main/resources/backend-crew.md");
        String name;
        while ((name = reader.readLine()) != null) {
            CrewRepository.addCrew(new Crew(name, Course.BACKEND));
        }
        reader.close();
    }

    public void setFrontCrew() throws IOException {
        BufferedReader reader = fileRead("/Users/guinness/java-pairmatching-precourse/src/main/resources/frontend-crew.md");
        String name;
        while ((name = reader.readLine()) != null) {
            CrewRepository.addCrew(new Crew(name,Course.FRONTEND));
        }
        reader.close();
    }

    public void setMissions(){
        List<Level> levels = Arrays.asList(Level.LEVEL1, Level.LEVEL2, Level.LEVEL4);
        List<String> LV1 = Arrays.asList("자동차경주","로또","숫자야구게임");
        List<String> LV2 = Arrays.asList("장바구니","결제","지하철노선도");
        List<String> LV4 = Arrays.asList("성능개선","배포");
        List<List<String>> missionList = Arrays.asList(LV1,LV2,LV4);

        for(int i = 0; i < 3; i++){
            for(String missionName : missionList.get(i)){
                Mission backMission = new Mission(Course.BACKEND,levels.get(i),missionName);
                MissionRepository.addMission(backMission);
                Mission frontMission = new Mission(Course.FRONTEND,levels.get(i),missionName);
                MissionRepository.addMission(frontMission);
            }
        }
    }

}
