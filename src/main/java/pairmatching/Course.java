package pairmatching;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    String getName() {
        return name;
    }

    public boolean isExist(String input) {
        if (name.equals(input)) {
            return true;
        }
        return false;
    }
}