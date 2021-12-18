package pairmatching.controller;

import pairmatching.domain.mission.MissionRepository;

public class MissionController {
    private final MissionRepository missionRepository;

    public MissionController(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    public void createMissions() {
        missionRepository.createMissions();
    }
}
