package pairmatching.domain;

import java.util.List;

public class Pair {
    private List<Crew> crewList;
    private Mission mission;

    public Pair(List<Crew> crewList, Mission mission) {
        this.crewList = crewList;
        this.mission = mission;
    }

    public List<Crew> getCrewList() {
        return crewList;
    }

    public Mission getMission() {
        return mission;
    }

    public void printPairInfo() {
        for (int i = 0; i < crewList.size()-1; i = i + 2) {
            Crew crew1 = crewList.get(i);
            Crew crew2 = crewList.get(i + 1);

            System.out.println(crew1.getName() + " : " + crew2.getName());
        }

        if (crewList.size() % 2 != 0) {
            System.out.println(" : " + crewList.get(crewList.size()-1));
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
