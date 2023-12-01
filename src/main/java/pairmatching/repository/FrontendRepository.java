package pairmatching.repository;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class FrontendRepository {
    private List<String> frontend;

    public FrontendRepository() {
        frontend = new ArrayList<>();
    }

    public void save(List<String> frontend) {
        this.frontend = frontend;
    }

    public List<String> getFrontend() {
        List<String> shuffle = Randoms.shuffle(frontend);
        return shuffle;
    }
}
