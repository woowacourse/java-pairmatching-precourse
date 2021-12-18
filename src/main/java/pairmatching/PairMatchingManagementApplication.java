package pairmatching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domain.Crew;
import pairmatching.utils.FileUtility;

public class PairMatchingManagementApplication {

    private final static List<String> readToListFromREADME = Arrays.asList("backend-crew.md", "frontend-crew.md");
    private final static int BECK_END = 0;
    private final static int FRONT_END = 1;

    private final FileUtility fileReadUtility;

    private List<Crew> backendCrews;
    private List<Crew> frontedCrews;

    public PairMatchingManagementApplication() {
        fileReadUtility = FileUtility.getInstance();
    }

    public void init() {
        readCrewsFromFile();
    }

    public void start() {
        init();
    }

    public void readCrewsFromFile() {
        backendCrews = new ArrayList<>();
        frontedCrews = new ArrayList<>();
        for (int group = 0; group < readToListFromREADME.size(); group++) {
            if (group == BECK_END) {
                backendCrews = fileReadUtility.readToListFromREADME(readToListFromREADME.get(group)).stream().map(Crew::new).collect(Collectors.toList());
            } else if (group == FRONT_END) {
                frontedCrews = fileReadUtility.readToListFromREADME(readToListFromREADME.get(group)).stream().map(Crew::new).collect(Collectors.toList());
            }
        }
    }
}
