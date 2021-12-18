package pairmatching.Model;

import java.util.ArrayList;
import java.util.List;

public class Pair {
    private List<Crew> members = new ArrayList<>();

    public Pair(Crew crew1, Crew crew2) {
        members.add(crew1);
        members.add(crew2);
    }

    public Pair(Crew crew1, Crew crew2, Crew crew3) {
        members.add(crew1);
        members.add(crew2);
        members.add(crew3);
    }

    public String toString() {
        String toString = "";
        if (members.size() == 2) {
            return members.get(0).getName() + " : " + members.get(1).getName();
        }
        return members.get(0).getName() + " : " + members.get(1).getName() + " : " + members.get(2).getName();
    }
}
