package pairmatching.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import pairmatching.domain.Level;
import pairmatching.domain.mission.MissionRepository;

public class MissionController {
    private final MissionRepository missionRepository;

    public MissionController(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    public void createMissions() {
        missionRepository.createMissions();
    }

    public List<String> findAllMissionNames() {
        return missionRepository.findAllMissionNames();
    }

    public Map<Level, List<String>> findMissionNamesByLevel() {
        return missionRepository.findMissionNamesByLevel();
    }
}
