package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Mission {
    private String name;
    private Course course;
    private Level level;
    private List<List<Crew>> matchingCrews = new ArrayList<>();

    public Mission(Course course, Level level, String name) {
        this.name = name;
        this.course = course;
        this.level = level;
    }

    public boolean isEqual(Course course, Level level, String name) {
        if (course == this.course && level == this.level && this.name.equals(name)) {
            return true;
        }
        return false;
    }

    public void removeMatching() {
        matchingCrews.clear();
    }

    public void addMatch(List<Crew> pair) {
        matchingCrews.add(pair);
    }

    public boolean isExistMatchingCrews() {
        if (matchingCrews.size() == 0) {
            return false;
        }
        return true;
    }

    public void printPair() {
        for (List<Crew> pair : matchingCrews) {
            if (pair.size() == 2) {
                pair.get(0).printName();
                System.out.printf(" : ");
                pair.get(1).printName();
                System.out.printf("\n");
                continue;
            }
            pair.get(0).printName();
            System.out.printf(" : ");
            pair.get(1).printName();
            System.out.printf(" : ");
            pair.get(2).printName();
            System.out.printf("\n");
        }
    }
}
