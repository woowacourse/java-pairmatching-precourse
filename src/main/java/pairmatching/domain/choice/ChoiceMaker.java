package pairmatching.domain.choice;

import pairmatching.domain.item.Course;
import pairmatching.domain.item.Level;
import pairmatching.domain.item.Mission;

import java.util.List;

public class ChoiceMaker {

    public Choice createChoice(List<String> choices) {
        Course course = Course.valueOfCourse(choices.get(0));
        Level level = Level.valueOfLevel(choices.get(1));
        Mission mission = Mission.valueOfMissionAndLevel(choices.get(2), level);
        return new Choice(course, mission);
    }
}
