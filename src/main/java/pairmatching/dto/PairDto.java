package pairmatching.dto;

import java.util.List;

import pairmatching.domain.Pair;

public class PairDto {
    private String firstCrewName;
    private String secondCrewName;
    private String thirdCrewName;

    public PairDto(List<String> names) {
        firstCrewName = names.get(0);
        secondCrewName = names.get(1);
        if (names.size() == 3) {
            thirdCrewName = names.get(2);
        }
    }

    public PairDto(Pair pair) {
        firstCrewName = pair.getFirstCrewName();
        secondCrewName = pair.getSecondCrewName();
        if (pair.hasThirdCrew()) {
            thirdCrewName = pair.getThirdCrewName();
        }
    }

    public String getFirstCrewName() {
        return firstCrewName;
    }

    public String getSecondCrewName() {
        return secondCrewName;
    }

    public String getThirdCrewName() {
        return thirdCrewName;
    }


}
