package domain;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
      this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public static Course findByName(String name) {
        return Arrays.stream(Course.values()).
                filter(c -> c.getName().equals(name)).
                findAny().
                orElseThrow(IllegalArgumentException:: new);
    }
}
