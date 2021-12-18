package pairmatching.Model;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    // 추가 기능 구현
}