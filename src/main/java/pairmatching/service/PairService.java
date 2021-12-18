package pairmatching.service;

import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.pair.Pair;
import pairmatching.domain.pair.PairRepository;
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

    public Pair createPairs(String[] pairInfo) {
        String courseName = pairInfo[0];
        String levelName = pairInfo[1];
        String missionName = pairInfo[2];
        List<String> crewNamesByCourse = crewRepository.getCrewNamesByCourse(Course.findByName(courseName).get());
        Pair pair = new Pair(missionName, crewNamesByCourse, findSameLevelPairsCrewNames(levelName));
        pair.match();
        pairRepository.save(missionName, pair);
        return pair;
    }

    private List<List<String>> findSameLevelPairsCrewNames(String levelName) {
        List<List<String>> sameLevelPairsCrewNames = new ArrayList<>();
        List<String> missionNamesByLevel = missionRepository.findMissionNamesByLevel(Level.findByName(levelName).get());
        for (String missionName : missionNamesByLevel) {
            Pair pair = pairRepository.findByMissionName(missionName);
            if(pair == null) {
                continue;
            }
            List<List<String>> pairsCrewNames = pair.getPairs();
            sameLevelPairsCrewNames.addAll(pairsCrewNames);
        }
        if(sameLevelPairsCrewNames.size() == 0) {
            return new ArrayList<>();
        }
        return sameLevelPairsCrewNames;
    }
}
