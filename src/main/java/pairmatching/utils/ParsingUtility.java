package pairmatching.utils;

import pairmatching.dto.CourseLevelMissionDto;

public class ParsingUtility {
    private ParsingUtility() {}

    public static ParsingUtility getInstance() {
        return ParsingUtility.LazyHolder.INSTANCE;
    }

    public CourseLevelMissionDto extractedPropertyInformation(String courseAndLevelAndMission) {
        String[] propertyInformation = courseAndLevelAndMission.split(",");
        for (int index = 0; index < propertyInformation.length; index++) {
            propertyInformation[index] = propertyInformation[index].trim();
        }
        String course = propertyInformation[0];
        String level = propertyInformation[1];
        String mission = propertyInformation[2];
        return new CourseLevelMissionDto(course, level, mission);
    }

    private static class LazyHolder {
        public static final ParsingUtility INSTANCE = new ParsingUtility();
    }
}
