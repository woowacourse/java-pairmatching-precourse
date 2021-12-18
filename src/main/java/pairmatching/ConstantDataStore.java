package pairmatching;

import java.util.*;
import java.util.stream.Collectors;

import pairmatching.domain.Crew;
import pairmatching.domain.Level;
import pairmatching.utils.FileUtility;

public class ConstantDataStore {
    private final static List<String> readToListFromREADME = Arrays.asList("backend-crew.md", "frontend-crew.md");
    private final static int BECK_END = 0;
    private final static int FRONT_END = 1;

    private final FileUtility fileReadUtility;

    private Map<Level, List<String>> missionByLevel;
    private List<Crew> backendCrews;
    private List<Crew> frontedCrews;

    private ConstantDataStore() {
        fileReadUtility = FileUtility.getInstance();
        injectMissionByLevelData();
        readCrewsFromFile();
    }

    public static ConstantDataStore getInstance() {
        return ConstantDataStore.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        public static final ConstantDataStore INSTANCE = new ConstantDataStore();
    }

    private void injectMissionByLevelData() {
        missionByLevel=new HashMap<>();
        List<String> level1 = Arrays.asList("자동차경주", "로또", "숫자야구게임");
        missionByLevel.put(Level.LEVEL1, level1);
        List<String> level2 = Arrays.asList("장바구니", "결제");
        missionByLevel.put(Level.LEVEL2, level2);
        List<String> level3 = new ArrayList<>();
        missionByLevel.put(Level.LEVEL3, level3);
        List<String> level4 = Arrays.asList("성능 개선", "배포");
        missionByLevel.put(Level.LEVEL4, level4);
        List<String> level5 = new ArrayList<>();
        missionByLevel.put(Level.LEVEL5, level5);
    }

    private void readCrewsFromFile() {
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

    public Map<Level, List<String>> getMissionByLevel() {
        return missionByLevel;
    }

    public List<Crew> getBackendCrews() {
        return backendCrews;
    }

    public List<Crew> getFrontedCrews() {
        return frontedCrews;
    }
}
