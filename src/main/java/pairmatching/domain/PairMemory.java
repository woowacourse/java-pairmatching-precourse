package pairmatching.domain;

import java.util.List;
import pairmatching.enums.Course;
import pairmatching.enums.Level;

public class PairMemory {
    Section section;
    List<List<String>> pairs;

    public PairMemory(Section section, List<List<String>> pairs) {
        this.section = section;
        this.pairs = pairs;
    }

    public Section getSection() {
        return section;
    }

    public List<List<String>> getPairs() {
        return pairs;
    }
}
