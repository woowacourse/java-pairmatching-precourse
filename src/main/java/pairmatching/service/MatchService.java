package pairmatching.service;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.repository.CrewRepository;
import pairmatching.view.OutputView;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static pairmatching.service.FileRead.fileRead;

public class MatchService {
    public boolean isEven(List<String> list) {
        if (list.size() % 2 == 0) {
            return true;
        }
        return false;
    }

    public List<String> makeCrewNameList(Course course) throws IOException {
        String file = null;
        if (course.equals(Course.BACKEND)) {
            file = "/Users/guinness/java-pairmatching-precourse/src/main/resources/backend-crew.md";

        }

        if (course.equals(Course.FRONTEND)) {
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

    public Mission evenMatch(List<String> crewNameList, Level level, Mission mission) {
        for (int i = 0; i < crewNameList.size() - 1; i += 2) {
            Crew crew1 = CrewRepository.findByName(crewNameList.get(i));
            Crew crew2 = CrewRepository.findByName(crewNameList.get(i + 1));
            if (!crew1.checkAlreadyPair(level, crew2) && !crew2.checkAlreadyPair(level, crew1)) {
                crew1.addAlreadyPair(level, crew2);
                crew2.addAlreadyPair(level, crew1);
                mission.addMatch(Arrays.asList(crew1, crew2));
                continue;
            }
        }
        return mission;
    }

    public Mission oddMatch(List<String> crewNameList, Level level, Mission mission) {
        for (int i = 0; i < crewNameList.size() - 3; i += 2) {
            Crew crew1 = CrewRepository.findByName(crewNameList.get(i));
            Crew crew2 = CrewRepository.findByName(crewNameList.get(i + 1));
            if (!crew1.checkAlreadyPair(level, crew2) && !crew2.checkAlreadyPair(level, crew1)) {
                crew1.addAlreadyPair(level, crew2);
                crew2.addAlreadyPair(level, crew1);
                mission.addMatch(Arrays.asList(crew1, crew2));
                continue;
            }

            Crew last1 = CrewRepository.findByName(crewNameList.get(crewNameList.size() - 3));
            Crew last2 = CrewRepository.findByName(crewNameList.get(crewNameList.size() - 2));
            Crew last3 = CrewRepository.findByName(crewNameList.get(crewNameList.size() - 1));
            if (!last1.checkAlreadyPair(level, last2) && !last1.checkAlreadyPair(level, last3)) {
                if (!last2.checkAlreadyPair(level, last1) && !last2.checkAlreadyPair(level, last3)) {
                    if (!last3.checkAlreadyPair(level, last1) && !last3.checkAlreadyPair(level, last2)) {
                        last1.addAlreadyPair(level, last2);
                        last1.addAlreadyPair(level, last3);
                        last2.addAlreadyPair(level, last1);
                        last2.addAlreadyPair(level, last3);
                        last3.addAlreadyPair(level, last1);
                        last3.addAlreadyPair(level, last2);
                        mission.addMatch(Arrays.asList(last1, last2, last3));
                    }
                }
            }
        }
        return mission;
    }

}
