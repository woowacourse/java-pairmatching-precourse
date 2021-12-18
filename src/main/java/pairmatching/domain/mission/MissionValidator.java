package pairmatching.domain.mission;

import pairmatching.domain.ErrorMessage;

public class MissionValidator {
    public void checkMissionName(String missionName) {
        for(BaseMission mission : BaseMission.values()){
            if (mission.getMission().getName().equals(missionName)){
                return;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.makeErrorMessage(
            "존재하지 않는 미션입니다. 다시 입력해주세요."));
    }
}
