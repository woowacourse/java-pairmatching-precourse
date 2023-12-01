package pairmatching.constants;

public enum FilePath {
    FRONT_FILE_PATH("/Users/2sh/Desktop/java-pairmatching-precourse/src/main/resources/frontend-crew.md"),
    BACK_FILE_PATH("/Users/2sh/Desktop/java-pairmatching-precourse/src/main/resources/backend-crew.md");
    private final String path;

    FilePath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
