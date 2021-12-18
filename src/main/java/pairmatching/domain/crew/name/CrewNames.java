package pairmatching.domain.crew.name;

import java.util.ArrayList;
import java.util.List;

public enum CrewNames {
    BACK_END("백호,태웅,치수,태섭,대만,준호,대협,덕규,태산,경태,수겸,현준,준섭,한나,소연,호열,대남,용팔,구식,달재"),
    FRONT_END("보노,시저,쉐리,신디,다비,덴버,이브,제시,라라,린다,리사,니콜,로드,윌터,제키");

    private List<String> nameList;

    CrewNames(String names) {
        this.nameList = new ArrayList<>();
        fillList(names);
    }

    private void fillList(String names) {
        for(String name : names.split(",")) {
            nameList.add(name);
        }
    }

    public List<String> getNameList() {
        return nameList;
    }

    public boolean isCount(int comparison) {
        return nameList.size() == comparison;
    }
}
