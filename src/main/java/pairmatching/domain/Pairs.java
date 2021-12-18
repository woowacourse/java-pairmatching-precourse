package pairmatching.domain;

import java.util.LinkedList;
import java.util.List;

public class Pairs {

    List<Pair> pairList;

    public Pairs() {
        pairList = new LinkedList<>();
    }

    public void add(List<String> names, String value) {
        pairList.add(new Pair(names, value));
    }

    public List<String> getNames(String value) {
        for (Pair pair : pairList) {
            if (pair.check(value)) {
                return pair.getNames();
            }
        }
        return null;
    }
}
