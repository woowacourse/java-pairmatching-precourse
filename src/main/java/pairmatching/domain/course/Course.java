package pairmatching.domain.course;

import pairmatching.domain.crew.name.CrewNames;

import java.util.List;

public enum Course {
    BACKEND("백엔드",CrewNames.BACK_END),
    FRONTEND("프런트엔드", CrewNames.FRONT_END);

    private String name;
    private CrewNames crewNames;

    Course(String name, CrewNames crewNames) {
        this.name = name;
        this.crewNames = crewNames;
    }

    public String getName() {
        return name;
    }

    public List<String> getNameList() {
        return crewNames.getNameList();
    }

    public boolean isNot(String input) {
        return !this.name.equals(input);
    }
}
