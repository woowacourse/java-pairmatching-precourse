package pairmatching.domain.choice;

import pairmatching.domain.choice.item.Course;
import pairmatching.domain.choice.item.Level;
import pairmatching.domain.choice.item.Mission;

import java.util.List;

public class ChoiceMaker {

    public Choice createChoice(List<String> items) {
        String courseName = items.get(0);
        String levelName = items.get(1);
        String missionName = items.get(2);
        validate(courseName, levelName, missionName);

        return new Choice(courseName, missionName);
    }

    private void validate(String courseName, String levelName, String missionName) {
        if (!Course.contains(courseName)) {
            throw new IllegalArgumentException("[ERROR] 해당하는 과정이 존재하지 않습니다.");
        }
        if (!Level.contains(levelName)) {
            throw new IllegalArgumentException("[ERROR] 해당하는 레벨이 존재하지 않습니다.");
        }
        if (!Mission.contains(missionName)) {
            throw new IllegalArgumentException("[ERROR] 해당하는 미션이 존재하지 않습니다.");
        }
        if (isValidLevel(levelName, missionName)) {
            throw new IllegalArgumentException("[ERROR] 레벨과 미션이 일치하지 않습니다.");
        }
    }

    private boolean isValidLevel(String level, String missionName) {
        Mission mission = Mission.valueOf(missionName);
        String levelOfMission = mission.getLevelMessage();
        return level.equals(levelOfMission);
    }
}
