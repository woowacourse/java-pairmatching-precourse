package pairmatching.service;

import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Pair;
import pairmatching.domain.PairRepository;
import pairmatching.domain.crew.CrewRepository;
import pairmatching.domain.mission.MissionRepository;

public class PairService {
    private final PairRepository pairRepository;
    private final CrewRepository crewRepository;
    private final MissionRepository missionRepository;

    public PairService(PairRepository pairRepository, CrewRepository crewRepository, MissionRepository missionRepository) {
        this.pairRepository = pairRepository;
        this.crewRepository = crewRepository;
        this.missionRepository = missionRepository;
    }

    public void createPairs(String[] pairInfo) {
        List<String> crewNamesByCourse = crewRepository.getCrewNamesByCourse(Course.findByName(pairInfo[0]).get());
        new Pair(pairInfo[2], crewNamesByCourse, findSameLevelPairsCrewNames(pairInfo[1]));
    }

    private List<List<String>> findSameLevelPairsCrewNames(String levelName) {
        List<List<String>> sameLevelPairsCrewNames = new ArrayList<>();
        List<String> missionNamesByLevel = missionRepository.findMissionNamesByLevel(Level.findByName(levelName).get());
        for (String missionName : missionNamesByLevel) {
            List<List<String>> pairsCrewNames = pairRepository.findByMissionName(missionName).getPairs();
            sameLevelPairsCrewNames.addAll(pairsCrewNames);
        }
        return sameLevelPairsCrewNames;
    }
}
