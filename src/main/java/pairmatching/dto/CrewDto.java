package pairmatching.dto;

import pairmatching.domain.Crew;

public class CrewDto {
    private final String name;

    public CrewDto(Crew crew) {
        this.name = crew.getName();
    }

    public CrewDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
