package pairmatching.domain;

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

    public void readCrewList123(String processName) throws IOException {
        if (processName.equals("백엔드")) {
            readCrewList(BACK_END_PROCESS_FILE_PATH);
        }
        if (processName.equals("프론트엔드")) {
            readCrewList(FRONT_END_PROCESS_FILE_PATH);
        }
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
}
