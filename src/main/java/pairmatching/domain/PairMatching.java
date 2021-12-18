package pairmatching.domain;

import java.util.List;

import pairmatching.utils.validator.CourseValidator;
import pairmatching.utils.validator.LevelValidator;
import pairmatching.utils.validator.MissionValidator;

public class PairMatching {

    private Crews crews;

    public PairMatching() {
        crews = new Crews();
    }

    public List<String> matching(String value) {
        String[] values = value.split(", ");
        List<String> crewNames = crews.matching(values[0]);
        return crewNames;
    }

    public void validate(String value) {
        String[] values = value.split(", ");
        CourseValidator.validate(values[0]);
        LevelValidator.validate(values[1]);
        MissionValidator.validate(values[2]);
    }
}
