package pairmatching;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;
import java.util.Map.Entry;

import camp.nextstep.edu.missionutils.Randoms;

public class PairManager {
    private static final String ERROR_NOT_MATCH = "[ERROR] 매칭이 되지 않았습니다.";
    private static final String FRONTEND = "프론트엔드";
    private static final String BACKEND = "백엔드";
    private static final String NOT_CONTAINED_ERROR = "[ERROR] 존재하지 않는 내역입니다.";

    HashMap<PairKey, ArrayList<Pair>> pairLog = new HashMap<>();
    CrewManager crewManager = new CrewManager();
    private static PairManager pairManager;

    private PairManager() {}

    public static PairManager getInstance() {
        if (pairManager == null) {
            pairManager = new PairManager();
        }
        return pairManager;
    }

    private ArrayList<Crew> setCrewList(String course) {
        if (course.equals(BACKEND)) {
            return crewManager.getBackEndCrewList();
        }
        if (course.equals(FRONTEND)) {
            return crewManager.getFrontEndCrewList();
        }
        return null;
    }

    public void executePairMatching(String course, String levelString, String mission) {
        ArrayList<Crew> crewList = setCrewList(course);
        ArrayList<Pair> pairList = new ArrayList<Pair>();
        int level = Integer.parseInt(levelString);
        for (int i = 0; i<3; i++) {
            Randoms.shuffle(crewList);
            Queue queue = new LinkedList(crewList);
            crewList = pairMatching(queue, pairList, level);;
        }
        if (!crewList.isEmpty()) {
            throw new IllegalArgumentException(ERROR_NOT_MATCH);
        }
        updateCrewData(pairList, level);
        pairLog.put(new PairKey(course, mission, level), pairList);
        PairOutput.printPairResult(pairList);
    }

    public boolean compareCrew(ArrayList<Crew> crews, int level) {
        return crews.get(0).checkCrew(crews.get(1), level)
                && crews.get(1).checkCrew(crews.get(2), level)
                && crews.get(2).checkCrew(crews.get(0), level);
    }

    public void addPair(ArrayList<Crew> crews, ArrayList<Pair> pairs) {
        pairs.add(new Pair(crews.get(0), crews.get(1)));
        pairs.add(new Pair(crews.get(1), crews.get(2)));
        pairs.add(new Pair(crews.get(2), crews.get(0)));
    }

    public boolean pushPair(ArrayList<Crew> crews, ArrayList<Pair> pairs, int level) {
        if (crews.size() == 2) {
            if (crews.get(0).checkCrew(crews.get(1), level)) {
                pairs.add(new Pair(crews.get(0), crews.get(1)));
                return true;
            }
        }
        if (crews.size() == 3) {
            if (compareCrew(crews, level)) {
                addPair(crews, pairs);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Crew> pairMatching(Queue<Crew> crewList, ArrayList<Pair> pairList, int level) {
        ArrayList<Crew> remainder = new ArrayList<Crew>();
        while (!crewList.isEmpty()) {
            ArrayList<Crew> crews = new ArrayList<>();
            addCrewGroup(crewList, crews);
            if (!pushPair(crews, pairList, level)) {
                remainder.addAll(crews);
            }
        }
        return remainder;
    }

    private void addCrewGroup(Queue<Crew> crewList, ArrayList<Crew> crews) {
        crews.add(crewList.poll());
        crews.add(crewList.poll());
        if (crewList.size() == 1) {
            crews.add(crewList.poll());
        }
    }

    private void updateCrewData(ArrayList<Pair> pairList, int level) {
        for (Pair pair : pairList) {
            pair.update(level);
        }
    }

    public ArrayList<Pair> getPairData(String course, String level, String mission) {
        ArrayList<Pair> pairDatas = pairLog.get(new PairKey(course, mission, Integer.parseInt(level)));
        if (pairDatas == null) {
            throw new IllegalArgumentException(NOT_CONTAINED_ERROR);
        }
        return pairDatas;
    }
}
