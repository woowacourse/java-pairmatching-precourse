package pairmatching.model;

import java.util.ArrayList;
import java.util.List;

public class Pair {
    private List<String> members = new ArrayList<>();

    public Pair() {
    }

    public void addMember(String member) {
        members.add(member);
    }

    public List<String> getMembers() {
        return this.members;
    }

    public boolean isEquals(Pair pair) {
        return members.containsAll(pair.getMembers());
    }
}
