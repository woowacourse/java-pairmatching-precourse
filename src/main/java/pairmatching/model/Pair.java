package pairmatching.model;

import java.util.ArrayList;
import java.util.List;

public class Pair {
    private final static String SEPARATOR = " : ";
    private List<String> members = new ArrayList<>();

    public Pair(String member1, String member2) {
        addMember(member1);
        addMember(member2);
    }

    public void addMember(String member) {
        members.add(member);
    }

    public List<String> getMembers() {
        return this.members;
    }

    public int getMemberCnt() {
        return this.members.size();
    }

    public boolean isEquals(Pair pair) {
        return getMemberCnt() == pair.getMemberCnt()
                && members.containsAll(pair.getMembers());
    }

    @Override
    public String toString() {
        return String.join(SEPARATOR, members);
    }
}
