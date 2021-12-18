package pairmatching.service;

import com.sun.tools.javac.util.List;
import pairmatching.MissionDto;
import pairmatching.domain.CrewRepository;
import pairmatching.domain.Crew;
import pairmatching.domain.Level;

import java.util.Arrays;

public class MatchService {
    public boolean isEven(List<String> list) {
        if (list.size() % 2 == 0) {
            return true;
        }
        return false;
    }

    public MissionDto evenMatch(List<String> crewNameList, Level level, MissionDto mission) {
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

    public MissionDto oddMatch(List<String> crewNameList, Level level, MissionDto mission) {
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
