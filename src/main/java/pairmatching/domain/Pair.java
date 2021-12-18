package pairmatching.domain;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Pair {
    private List<Crew> crewList;
    private Map<String, String> pairMap = new TreeMap<>();
    private Mission mission;

    public Pair(List<Crew> crewList, Mission mission) {
        this.crewList = crewList;
        this.mission = mission;
        makePairMap();
    }

    public List<Crew> getCrewList() {
        return crewList;
    }

    public Mission getMission() {
        return mission;
    }

    public Map<String, String> getPairMap() {
        return pairMap;
    }

    public void printPairInfo() {
        for (int i = 0; i < crewList.size()-1; i = i + 2) {
            Crew crew1 = crewList.get(i);
            Crew crew2 = crewList.get(i + 1);

            if (i == crewList.size()-3) {
                System.out.print(crew1.getName() + " : " + crew2.getName());
                break;
            }

            System.out.println(crew1.getName() + " : " + crew2.getName());
        }

        if (crewList.size() % 2 != 0) {
            System.out.println(" : " + crewList.get(crewList.size()-1).getName());
        }
    }

    public void makePairMap() {
        for (int i = 0; i < crewList.size() -1; i = i +2) {
            Crew crew1 = crewList.get(i);
            Crew crew2 = crewList.get(i + 1);

            if (i == crewList.size()-3) {
                Crew crew3 = crewList.get(i+2);
                pairMap.put(crew1.getName(), crew2.getName());
                pairMap.put(crew1.getName(), crew3.getName());

                pairMap.put(crew2.getName(), crew1.getName());
                pairMap.put(crew2.getName(), crew3.getName());

                pairMap.put(crew3.getName(), crew1.getName());
                pairMap.put(crew3.getName(), crew2.getName());
                break;
            }

            pairMap.put(crew1.getName(), crew2.getName());
            pairMap.put(crew2.getName(), crew1.getName());
        }
    }

    public void checkPairMapWithPair(Pair pair) {
        for (String key : pair.getPairMap().keySet()) {
            if (this.pairMap.containsKey(key)) {
                checkPairMap(pairMap, key);
            }
        }
    }

    private void checkPairMap(Map<String, String> pairMap, String key) {
        if (pairMap.get(key).equals(this.pairMap.get(key))) {
            throw new IllegalArgumentException("동일한 쌍이 존재");
        }
    }

    @Override
    public boolean equals(Object object) {
        Pair pair = (Pair) object;

        if (this.mission == pair.getMission()) {
            if (this.crewList.get(0).getCourse() == pair.getCrewList().get(0).getCourse()) {
                return true;
            }
        }

        return false;
    }
}
