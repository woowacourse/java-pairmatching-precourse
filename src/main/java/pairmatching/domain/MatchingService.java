package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.view.OutputView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static pairmatching.constant.SystemMessage.*;

public class MatchingService {
    private CrewList crewList = new CrewList();
    private CrewList shuffledCrewList = new CrewList();

    public MatchingService(String processName) {
        readCrewList(processName);
        shuffleCrewList();
    }

    public CrewList match(String processName, String levelName, String missionName) {
        int count = INIT_CHANCE;
        Level level = Level.getLevel(levelName);
        while (shuffledCrewList.isMatched(level)) {
            List<String> shuffledCrewListString = crewList.shuffle();
            shuffledCrewList.toCrewListBy(shuffledCrewListString);
            count++;
            if (count == LIMIT_CHANCE) break;
        }
        shuffledCrewList.addPartner(level);
        return shuffledCrewList;
    }

    private void readCrewList(String processName) {
        try {
            String filePath = makeFilePath(processName);
            BufferedReader reader = new BufferedReader(
                    new FileReader(filePath)
            );
            String crewName;
            while ((crewName = reader.readLine()) != null) {
                crewList.add(crewName);
            }
        } catch (IOException exception) {

        }
    }

    private void shuffleCrewList() {
        List<String> shuffledCrewListString = crewList.shuffle();
        shuffledCrewList.initCrewListBy(shuffledCrewListString);
    }

    private String makeFilePath(String processName) {
        if (processName.equals(BACK_END)) {
            return BACK_END_PROCESS_FILE_PATH;
        }
        return FRONT_END_PROCESS_FILE_PATH;
    }
}
