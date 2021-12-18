package pairmatching;

import java.util.ArrayList;
import java.util.List;

public class Partner {

    private List<String> names;

    public Partner() {
        this.names = new ArrayList<>();
    }

    public String printFormatName() {
        return String.join(" : ", names);
    }

    public void addName(String crewName) {
        this.names.add(crewName);
    }
}
