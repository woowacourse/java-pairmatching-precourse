package pairmatching.domain;

import java.util.*;
import java.io.*;

public class PairHistory {
    private Map<Crew, Set<Crew>> pairHistory;

    public PairHistory() {
        this.pairHistory = new HashMap<>();
    }

    public void addPair(Crew crew1, Crew crew2) {
        pairHistory.putIfAbsent(crew1, new HashSet<>());
        pairHistory.putIfAbsent(crew2, new HashSet<>());
        pairHistory.get(crew1).add(crew2);
        pairHistory.get(crew2).add(crew1);
    }

    public boolean werePairedBefore(Crew crew1, Crew crew2) {
        return pairHistory.getOrDefault(crew1, new HashSet<>()).contains(crew2);
    }
}

