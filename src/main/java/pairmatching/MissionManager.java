package pairmatching;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.errorMessage.ErrorMessage;
import pairmatching.missionName.MissionName;

import java.io.FileNotFoundException;
import java.util.*;

public class MissionManager {

    public static final int CREW_REMOVE_INDEX = 0;


    public static final int FIRST_PAIR_CREW_INDEX = 0;
    public static final int SECOND_PAIR_CREW_INDEX = 1;
    public static final int THIRD_PAIR_CREW_INDEX = 2;


    private Map<Level, List<Mission>> missionMap = new HashMap<Level, List<Mission>>(){{
        put(Level.LEVEL1, new ArrayList<Mission>());
        put(Level.LEVEL2, new ArrayList<Mission>());
        put(Level.LEVEL3, new ArrayList<Mission>());
        put(Level.LEVEL4, new ArrayList<Mission>());
        put(Level.LEVEL5, new ArrayList<Mission>());
    }};

    public void init() {
        for (Level level : Level.values()) {
            initializeMissionMap(level);
        }
    }

    public void initializeMissionMap(Level level) {
        for (MissionName missionName : LevelMission.levelMissionMap.get(level)) {
            missionMap.get(level).add(new Mission(Course.FRONTEND, missionName));
            missionMap.get(level).add(new Mission(Course.BACKEND, missionName));
        }
    }

    public List<Pair> getPairList(Course course, Level level, MissionName missionName) {
        return missionMap.get(level).stream()
                .filter(mission -> mission.getMissionName() == missionName)
                .findFirst()
                .orElseThrow(() ->  new IllegalArgumentException("해당 이름의 미션이 없습니다."))
                .getPairList();
    }

    public boolean isMatched(Course course, Level level, MissionName missionName) {
        return missionMap.get(level).stream()
                .filter(mission -> mission.getMissionName() == missionName)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 이름의 미션이 없습니다."))
                .isMatched();
    }

    public void generatePair(Course course, Level level, MissionName missionName) throws FileNotFoundException {
        String fileLocation = NameReader.getFileLocation(course);
        List<String> crewNameList = NameReader.readCrewName(fileLocation);
        List<String> shuffledNameList = Randoms.shuffle(crewNameList);
        List<Pair> pairList = new ArrayList<>();
        while (shuffledNameList.size() != 0) {
            pairList.add(createPair(shuffledNameList.get(CREW_REMOVE_INDEX),
                    shuffledNameList.get(CREW_REMOVE_INDEX),
                    level, course));

            shuffledNameList.remove(CREW_REMOVE_INDEX);
            shuffledNameList.remove(CREW_REMOVE_INDEX);

            if (shuffledNameList.size() == 3) {
                pairList.add(createPair(shuffledNameList.get(FIRST_PAIR_CREW_INDEX),
                        shuffledNameList.get(SECOND_PAIR_CREW_INDEX),
                        shuffledNameList.get(THIRD_PAIR_CREW_INDEX),
                        level, course));

                shuffledNameList.remove(CREW_REMOVE_INDEX);
                shuffledNameList.remove(CREW_REMOVE_INDEX);
                shuffledNameList.remove(CREW_REMOVE_INDEX);
                break;
            }
        }

        setPairList(level, course, missionName,  pairList);
    }

    private Pair createPair(String firstCrewName, String secondCrewName, Level level, Course course) {
        if (wasPair(level, firstCrewName, secondCrewName)) {
            throw new DuplicateFormatFlagsException(ErrorMessage.DUPLICATE_PAIR.getCompleteMessage());
        }

        Crew firstCrew = new Crew(course, firstCrewName);
        Crew secondCrew = new Crew(course, secondCrewName);
        Pair pair = new Pair();
        pair.addMember(firstCrew);
        pair.addMember(secondCrew);

        return pair;
    }

    private Pair createPair(String firstCrewName, String secondCrewName, String thirdCrewName, Level level, Course course) {
        if (wasPair(level, firstCrewName, secondCrewName)
                || wasPair(level, firstCrewName, thirdCrewName)
                || wasPair(level, secondCrewName, thirdCrewName)) {
            throw new DuplicateFormatFlagsException(ErrorMessage.DUPLICATE_PAIR.getCompleteMessage());
        }
        Crew firstCrew = new Crew(course, firstCrewName);
        Crew secondCrew = new Crew(course, secondCrewName);
        Crew thirdCrew = new Crew(course, thirdCrewName);
        Pair pair = new Pair();
        pair.addMember(firstCrew);
        pair.addMember(secondCrew);
        pair.addMember(thirdCrew);

        return pair;
    }


    public boolean wasPair(Level level, String crewName1, String crewName2) {
        List<Mission> missionList = missionMap.get(level);
        List<Pair> pairList = new ArrayList<>();

        for (Mission mission : missionList) {
            pairList.addAll(mission.getPairList());
        }

        return pairList.stream()
                        .anyMatch(pair -> pair.isPair(crewName1, crewName2));
    }

    public void setPairList(Level level, Course course,  MissionName missionName, List<Pair> pairList) {
        missionMap.get(level).stream()
                .filter(mission -> mission.getMissionName() == missionName)
                .filter(mission -> mission.getCourse() == course)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 이름의 미션이 없습니다."))
                .setPairList(pairList);
    }

    public List<Mission> getMissionListOfLevel(Level level) {
        return missionMap.get(level);
    }

    public boolean isMissionExists(Level level, Course course,  MissionName missionName) {
        return missionMap.get(level).stream()
                .filter(mission -> mission.getMissionName() == missionName)
                .filter(mission -> mission.getCourse() == course)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 이름의 미션이 없습니다."))
                .isPairListExists();
    }
}
