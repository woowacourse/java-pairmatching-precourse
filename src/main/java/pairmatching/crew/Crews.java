package pairmatching.crew;

import java.util.ArrayList;
import java.util.List;

public class Crews {
    private List<Crew> frontEndCrews;
    private List<Crew> backEndCrews;

    public Crews() {
        this.frontEndCrews = new ArrayList<>();
        this.backEndCrews = new ArrayList<>();
    }

    public void setFrontEndCrews(List<Crew> crews) {
        this.frontEndCrews = crews;
    }

    public void setBackEndCrews(List<Crew> crews) {
        this.backEndCrews = crews;
    }
}
