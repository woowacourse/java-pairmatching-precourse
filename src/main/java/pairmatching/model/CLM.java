package pairmatching.model;

import java.util.List;

public class CLM {
    private String course;
    private String level;
    private String mission;

    public CLM(List<String> input) {
        this.course = input.get(0);
        this.level = input.get(1);
        this.mission = input.get(2);
    }

    public String getCourse() {
        return this.course;
    }

    public String getLevel() {
        return this.level;
    }

    public String getMission() {
        return this.mission;
    }

    public boolean isSame(CLM clm1, CLM clm2) {
        if (clm1.getCourse().equals(clm2.getCourse()) && clm1.getLevel().equals(clm2.getLevel()) && clm1.getMission().equals(clm2.getMission())) {
            return true;
        }
        return false;
    }
}
