package pairmatching.domain;

import pairmatching.dto.PairDto;

public class Pair {
    private Crew firstCrew;
    private Crew secondCrew;
    private Crew thirdCrew;

    public Pair(PairDto pairDto) {
        this.firstCrew = new Crew(pairDto.getFirstCrewName());
        this.secondCrew = new Crew(pairDto.getSecondCrewName());
        if (pairDto.getThirdCrewName() != null) {
            this.thirdCrew = new Crew(pairDto.getThirdCrewName());
        }
    }

    public String getFirstCrewName() {
        return firstCrew.getName();
    }
    public String getSecondCrewName() {
        return secondCrew.getName();
    }
    public String getThirdCrewName() {
        return thirdCrew.getName();
    }

    public boolean hasThirdCrew() {
        return thirdCrew != null;
    }
}
