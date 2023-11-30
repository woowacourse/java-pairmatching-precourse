package pairmatching.repository;

import java.util.List;

public class BackendRepository {
    private List<String> backend;

    public void save(List<String> backend) {
        this.backend = backend;
    }

    public List<String> getBackend() {
        return backend;
    }
}
