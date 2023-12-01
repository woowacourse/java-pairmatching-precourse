package pairmatching.repository;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BackendRepository {
    private List<String> backend;

    public BackendRepository() {
        backend = new ArrayList<>();
    }

    public void save(List<String> backend) {
        this.backend = backend;
    }

    public List<String> getBackend() {
        List<String> shuffle = Randoms.shuffle(backend);
        return shuffle;
    }
}
