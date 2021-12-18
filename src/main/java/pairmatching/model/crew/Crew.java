package pairmatching.model.crew;

import pairmatching.model.information.CourseLevelName;
import pairmatching.model.information.CourseMissionName;
import pairmatching.model.information.CourseName;

public class Crew {
    private CourseName courseName;
    private CourseLevelName courseLevelName;
    private CourseMissionName courseMissionName;
    private String crewName;

    public Crew(final CourseName courseName, final CourseLevelName courseLevelName, final CourseMissionName courseMissionName) {
        this.courseName = courseName;
        this.courseLevelName = courseLevelName;
        this.courseMissionName = courseMissionName;
    }


}
