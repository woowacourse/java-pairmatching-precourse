package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static pairmatching.constant.SystemMessage.BACK_END_PROCESS_FILE_PATH;
import static pairmatching.constant.SystemMessage.FRONT_END_PROCESS_FILE_PATH;

public class MatchingService {
    List<String> crewList = new ArrayList<>();
    List<String> shuffledCrewList;

    public void match(String processName) throws IOException {
        String filePath = makeFilePath(processName);
        readCrewList(filePath);
        shuffleCrewList();
    }

    private void readCrewList(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader(filePath)
        );
        String crewName;
        while ((crewName = reader.readLine()) != null) {
            crewList.add(crewName);
        }
    }

    private void shuffleCrewList() {
        shuffledCrewList = Randoms.shuffle(crewList);
    }

    private String makeFilePath(String processName) {
        if (processName.equals("백엔드")) {
            return BACK_END_PROCESS_FILE_PATH;
        }
        return FRONT_END_PROCESS_FILE_PATH;
    }
}
