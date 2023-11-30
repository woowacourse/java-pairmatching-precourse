package pairmatching.repository;

import java.util.ArrayList;
import java.util.List;

public class FrontendRepository {
    private List<String> frontend = new ArrayList<>();

    public FrontendRepository() {

    }

    public void save(List<String> frontend) {
        this.frontend = frontend;
    }

    public List<String> getFrontend() {
        return frontend;
    }
}
